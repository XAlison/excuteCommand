package com.mapper;


import com.model.Token;

public interface TokenMapper {

    /**
     * 添加token
     */
    int addToken(Token token);

    /**
     * token查询token信息
     */
    Token findTokenInfoByToken(String token);

    /**
     * memberId查询token
     */
    Token findTokenByMemberId(String memberId);

    /**
     * 更新token
     */
    int updateToken(Token token);


}