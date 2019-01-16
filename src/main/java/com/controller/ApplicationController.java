package com.controller;


import com.common.utils.Result;
import com.model.Application;
import com.model.ApplicationModel;
import com.model.Member;
import com.service.ApplicationService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/addApplication")
    public Result addApplication(@RequestBody ApplicationModel model) {
        Application application=new Application();
        application.setId(UUID.randomUUID().toString());
//        application.setCreator(copy.getCreator());
//        application.setApplicationName(copy.getApplicationName());
//        application.setApplicationDescription(copy.getApplicationDescription());
//        application.setLogo(copy.getLogo());
//        application.setProdDomain(copy.getProdDomain());
//        application.setTestDomain(copy.getTestDomain());
//        application.setStatus(copy.getStatus());
//        application.setApplicationStatus(copy.getApplicationStatus());
//        application.setKeepRecord(copy.getKeepRecord());
//        application.setCreateTime(copy.getCreateTime());
//        application.setReleaseTime(copy.getReleaseTime());
//        application.setVersion(copy.getVersion());
        int result = applicationService.addApplication(application);
        return result > 0 ? Result.ok("设置成功") : Result.ok("设置失败");
    }
}


