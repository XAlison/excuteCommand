package com.excutecommand.demo;

import com.model.BaseTable;
import com.service.CommandService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private CommandService commandService;
    @Test
    public void contextLoads() {
        List<BaseTable> obj = commandService.selectBaseTables();
        System.err.print(obj);
    }

}

