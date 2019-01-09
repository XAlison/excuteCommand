package com.model;

import java.util.Date;
import lombok.Data;

@Data
public class Member {
    private String id;

    private String phone;

    private String memberName;

    private String companyName;

    private String password;

    private Integer status;

    private Date registerTime;

}