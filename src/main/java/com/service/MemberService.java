package com.service;

import com.mapper.MemberMapper;
import com.model.Member;
import com.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public int register(Member member) {
        return memberMapper.register(member);
    }

    public Member login(Member member) {
        return memberMapper.login(member);
    }

    public Member findMemberByPhone(String phone) {
        return memberMapper.findMemberByPhone(phone);
    }

    public Member findMemberById(String memberId) {
        return memberMapper.findMemberById(memberId);
    }


    public int setPassword(Member member) {
        return memberMapper.setPassword(member);
    }

}
