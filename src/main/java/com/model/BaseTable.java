package com.model;

import java.util.List;
import java.util.Map;

public class BaseTable {
    private String name;
    private List<BaseColumn> columns;
    private List<Map<String, Object>> rows;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BaseColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<BaseColumn> columns) {
        this.columns = columns;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }

}
