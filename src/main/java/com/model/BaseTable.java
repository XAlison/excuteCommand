package com.model;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class BaseTable {
    private String name;
    private List<BaseColumn> columns;
    private List<Map<String, Object>> rows;
}
