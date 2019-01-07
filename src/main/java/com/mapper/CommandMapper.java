package com.mapper;


import com.model.BaseTable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommandMapper {
    List<BaseTable> selectBaseTables();

    int executeSqlCmd(@Param("paramSQL")String paramSQL);
}