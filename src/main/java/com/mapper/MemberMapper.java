package com.mapper;


import com.model.Member;
import com.model.Token;

public interface MemberMapper {
    /**
     * 会员登录
     */
    Member login(Member member);

    /**
     * 会员注册
     */
    int register(Member member);

    /**
     * 手机号查找指定会员
     */
    Member findMemberByPhone(String phone);

    /**
     * 会员id查找指定会员
     */
    Member findMemberById(String memberId);

    /**
     * 密码设置
     */
    int setPassword(Member member);

}