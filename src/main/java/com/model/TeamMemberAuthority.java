package com.model;

import java.util.Date;
import lombok.Data;

@Data
public class TeamMemberAuthority {
    private String id;

    private String applicationId;

    private String memberId;

    private String teamId;

    private Boolean isViewDetails;

    private Boolean isRelease;

    private Boolean isDevelop;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}