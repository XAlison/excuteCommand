package com.controller;


import com.model.BaseTables;
import com.service.CommandService;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/command")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @RequestMapping("/getTables")
    public List<BaseTables> getTables(HttpServletRequest request) throws IOException, SQLException {
        // 遍历生成执行sql
        List<BaseTables> baseTables = commandService.selectBaseTables();
        StringBuffer buffer = new StringBuffer();
        baseTables.forEach(table -> {
            table.getRows().forEach(row -> {
                List<String> fields = new ArrayList<>();
                List<String> values = new ArrayList<>();
                table.getColumns().forEach(column -> {
                    fields.add(column);
                    values.add(row.get(column) != null ? "'" + row.get(column).toString() + "'" : "''");
                });
                String filedStr = " (" + StringUtils.join(fields, ",") + ") ";
                String valueStr = " (" + StringUtils.join(values, ",") + ")";
                String cmdSql = "INSERT INTO ".concat(table.getName()).concat(filedStr).concat("VALUES").concat(valueStr).concat(";");
                System.err.print(cmdSql + "\r\n");
                buffer.append(cmdSql).append("\r\n");
            });
        });

        String targetSql=buffer.toString().replaceAll("(?<=\\b\\d{4}-\\d{2}-\\d{2} \\d{1,2}:\\d{1,2}:\\d{1,2})\\.0\\b", "");


       int result= commandService.executeSqlCmd(targetSql);

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a2?characterEncoding=utf8&serverTimezone=GMT%2B8&allowMultiQueries=true&allowMultiQueries=true&zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "root");
        ScriptRunner runner = new ScriptRunner(conn);
        //设置不自动提交
        runner.setAutoCommit(false);
        runner.setStopOnError(true);
        runner.setFullLineDelimiter(false);
       runner.runScript(new InputStreamReader(new ByteArrayInputStream(targetSql.getBytes()), "utf-8"));
        runner.closeConnection();
        conn.close();




        String slqPath = UUID.randomUUID() + ".sql";
        File f = new File(slqPath);
        FileWriter fw = null;
        BufferedWriter bw = null;
        if (f.exists()) {
            f.delete();
        }
        if (!f.exists()) {
            f.createNewFile();
        }
        fw = new FileWriter(f.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(buffer.toString());
        bw.close();

        return baseTables;
    }
}


