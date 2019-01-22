package com.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: AliyunConfig
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2019/1/14 14:14
 * @Version 1.0
 */
@Configuration
@PropertySource("classpath:/aliyun-verify.properties")
public class AliyunConfig {
    @Value("${aliyun.verify.regionId}")
    private String regionId;
    @Value("${aliyun.verify.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.verify.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.verify.key}")
    private String key;

    @Bean
    public IAcsClient client() throws Exception {
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "afs", "afs.aliyuncs.com");
        return client;
    }
}
