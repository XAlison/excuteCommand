package com.service;

import com.datasources.DataSourceNames;
import com.datasources.annotation.DataSource;
import com.mapper.CommandMapper;
import com.model.BaseTable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {
    @Autowired
    private CommandMapper commandMapper;

    @DataSource(name = DataSourceNames.SECOND)
    public List<BaseTable> selectBaseTables() {
        return commandMapper.selectBaseTables();
    }

    @DataSource(name = DataSourceNames.SECOND)
    public int executeSqlCmd(String paramSQL) {
        return commandMapper.executeSqlCmd(paramSQL);
    }
}
