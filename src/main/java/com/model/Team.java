package com.model;

import java.util.Date;
import lombok.Data;

@Data
public class Team {
    private String id;

    private String teamName;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private Integer status;
}