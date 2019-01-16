package com.model;

import java.util.Date;
import lombok.Data;

@Data
public class Token {
    private String memberId;

    private String token;

    private Date expireTime;

    private Date updateTime;
}

