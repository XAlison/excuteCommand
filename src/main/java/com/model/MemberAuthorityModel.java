package com.model;

import lombok.Data;

@Data
public class MemberAuthorityModel {
    private String applicationId;
    private String applicationName;
    private boolean isViewDetails;
    private boolean isRelease;
    private boolean isDevelop;
}
