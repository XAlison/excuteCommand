package com.mapper;


import com.model.Member;

public interface MemberMapper {
    /**
     * 会员登录
     */
    Member login(String phone, String password);

    /**
     * 会员注册
     */
    int register(Member member);

    /**
     * 手机号查找指定会员
     */
    Member findMemberByPhone();

    /**
     * 密码设置
     */
    int setPassword(String memberId, String password);

}