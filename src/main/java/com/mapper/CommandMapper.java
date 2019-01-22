package com.mapper;


import com.datasources.DataSourceNames;
import com.datasources.annotation.DataSource;
import com.model.BaseTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommandMapper {

    @DataSource(name = DataSourceNames.SECOND)
    List<BaseTable> selectBaseTables();

    int executeSqlCmd(@Param("paramSQL") String paramSQL);
}