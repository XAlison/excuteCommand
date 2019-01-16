package com.model;

import java.util.Date;
import lombok.Data;

@Data
public class TeamMemberInvite {
    private String id;

    private String memberId;

    private String teamId;

    private String inviteCode;

    private Integer status;

    private Date createTime;

    private Date invalidTime;
}