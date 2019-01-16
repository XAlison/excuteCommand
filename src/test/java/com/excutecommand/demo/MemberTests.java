package com.excutecommand.demo;

import com.model.BaseTable;
import com.model.Member;
import com.service.CommandService;
import com.service.MemberService;
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
public class MemberTests {
    @Autowired
    private MemberService memberService;
    @Test
    public void contextLoads() {
        Member member =new Member();
        member.setId("222ef3b8-9525-4f97-aa6e-081efb66df43");
        member.setPhone("15087429695");
        member.setMemberName("张三");
        member.setPassword("9999999");
        member.setCompanyName("北京华奥汽车服务有限公司");
        member.setStatus(1);
        member.setRegisterTime(new Date());
        int obj = memberService.setPassword(member);
        System.err.print(obj);
    }

}

