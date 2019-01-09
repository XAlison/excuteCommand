package com.mapper;


import com.model.MemberApplication;

public interface ApplicationMapper {
    MemberApplication findApplicationByDomain(String domain);
}