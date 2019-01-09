package com.model;

import java.util.Date;
import lombok.Data;

@Data
public class MemberApplication {
    private String id;

    private String creator;

    private String applicationName;

    private String applicationDescription;

    private String logo;

    private String prodDomain;

    private String testDomain;

    private Integer status;

    private Integer applicationStatus;

    private Date createTime;

    private Date releaseTime;

    private String version;
}