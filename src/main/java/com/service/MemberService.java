package com.service;

import com.mapper.MemberMapper;
import com.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public int register(Member member) {
        return memberMapper.register(member);
    }
}
