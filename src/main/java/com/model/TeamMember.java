package com.model;

import java.util.Date;
import lombok.Data;

@Data
public class TeamMember {
    private String id;

    private String teamName;

    private String memberId;

    private Integer status;

    private Date joinTime;
}