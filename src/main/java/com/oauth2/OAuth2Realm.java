package com.oauth2;

import com.model.Member;
import com.model.Token;
import com.service.MemberService;
import com.service.TokenService;
import javax.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * 认证
 *
 * @author LingDu
 * @version 1.0
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Resource
    private MemberService memberService;
    @Resource
    private TokenService tokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(暂时保留授权)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Member member = (Member) principals.getPrimaryPrincipal();
        return member != null ? new SimpleAuthorizationInfo() : null;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();
        Token tokenEntity = tokenService.findTokenInfoByToken(accessToken);
        // token失效
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        Member member = memberService.findMemberById(tokenEntity.getMemberId());
        return new SimpleAuthenticationInfo(member, accessToken, getName());
    }
}
