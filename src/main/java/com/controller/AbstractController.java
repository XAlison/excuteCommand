package com.controller;

import com.model.Member;
import org.apache.shiro.SecurityUtils;

/**
 * Controller公共组件
 */
public abstract class AbstractController {

    protected Member getMember() {
        return (Member) SecurityUtils.getSubject().getPrincipal();
    }

    protected String getMemberId() {
        return getMember().getId();
    }

}
