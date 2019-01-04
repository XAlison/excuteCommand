package com.service;

import com.mapper.CommandMapper;
import com.model.BaseTables;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {
    @Autowired
    private CommandMapper commandMapper;

    public List<BaseTables> selectBaseTables() {
        return commandMapper.selectBaseTables();
    }

    public int executeSqlCmd(String paramSQL) {
        return commandMapper.executeSqlCmd(paramSQL);
    }
}