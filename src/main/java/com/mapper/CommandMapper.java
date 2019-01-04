package com.mapper;


import com.model.BaseTables;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommandMapper {
    List<BaseTables> selectBaseTables();

    int executeSqlCmd(@Param("paramSQL")String paramSQL);
}