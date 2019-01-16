package com.service;

import com.mapper.ApplicationMapper;
import com.model.Application;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;

    public int addApplication(Application application) {
        return applicationMapper.addApplication(application);
    }

    public int updateApplication(Application application) {
        return applicationMapper.updateApplication(application);
    }

    public Application findApplicationByDomain(String domain) {
        return applicationMapper.findApplicationByDomain(new HashMap<String, String>() {{
            put("domain", domain);
        }});
    }

    public Application findApplicationById(String id) {
        return applicationMapper.findApplicationById(new HashMap<String, String>() {{
            put("id", id);
        }});
    }
}
