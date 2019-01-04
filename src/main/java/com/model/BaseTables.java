package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseTables
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2019/1/3 10:41
 * @Version 1.0
 */
public class BaseTables {
    private String name;
    private List<String> columns;
    private List<Map<String,Object>> rows;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }
}
