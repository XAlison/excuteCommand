package com.controller;

/**
 * @ClassName: test1
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2019/1/4 17:39
 * @Version 1.0
 */
public class test1 {
    public static void main(String[] args) {

        String str = "2、开标时间：2018-08-03 14:02:23.0 开标时间：2018-08-02 16:00:00.0";
        System.err.print(str.replaceAll("(?<=\\b\\d{4}-\\d{2}-\\d{2} \\d{1,2}:\\d{1,2}:\\d{1,2})\\.0\\b", ""));
    }
}

