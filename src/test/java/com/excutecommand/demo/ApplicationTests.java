package com.excutecommand.demo;

import com.model.Application;
import com.model.MemberAuthorityModel;
import com.model.TeamViewModel;
import com.service.ApplicationService;
import com.service.MemberService;
import com.service.TeamService;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private MemberService memberService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private ApplicationService applicationService;
    @Test
    public void contextLoads() {

        Application application=new Application();
        application.setId("059e583b-101c-4426-a389-abcd279c0a54");
        application.setCreator("222ef3b8-9525-4f97-aa6e-081efb66df42");
        application.setApplicationName("北京华奥设计平台");
        application.setApplicationDescription("北京华奥设计平台");
        application.setLogo("");
        application.setProdDomain("www.taobao.com");
        application.setTestDomain("www.baidu.com");
        application.setStatus(1);
        application.setApplicationStatus(3);
        application.setKeepRecord("京公网安备 11010102002019号");
        application.setCreateTime(new Date());
        application.setVersion("1.0.1");
        //int result = applicationService.addApplication(application);
        //int result= applicationService.updateApplication(application);
        Application result1 = applicationService.findApplicationById("059e583b-101c-4426-a389-abcd279c0a54");
        Application result2 = applicationService.findApplicationByDomain("www.taobao.com");
        System.err.print(result1);
    }

}

