package com.service;

import com.common.utils.Result;
import com.mapper.TokenMapper;
import com.model.Token;
import com.oauth2.TokenGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    private TokenMapper tokenMapper;
    // 12小时后过期
    private final static int EXPIRE = 3600 * 12;

    public Result addToken(String memberId) throws NoSuchAlgorithmException {
        // 生成一个token
        String token = TokenGenerator.generateValue();
        // 当前时间
        Date now = new Date();
        // 过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        // 判断是否生成过token
        Token tokenEntity = tokenMapper.findTokenByMemberId(memberId);
        if (tokenEntity == null) {
            tokenEntity = new Token();
            tokenEntity.setMemberId(memberId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            tokenMapper.addToken(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            tokenMapper.updateToken(tokenEntity);
        }
        return Result.ok()
                .put("token", token)
                .put("expire", EXPIRE);
    }

    public Token findTokenInfoByToken(String token) {
        return tokenMapper.findTokenInfoByToken(token);
    }
}
