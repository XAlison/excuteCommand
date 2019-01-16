package com.mapper;


import com.model.Application;
import java.util.Map;

public interface ApplicationMapper {

    int addApplication(Application application);

    int updateApplication(Application application);

    Application findApplicationByDomain(Map<String, String> map);

    Application findApplicationById(Map<String, String> map);
}