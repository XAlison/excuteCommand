package com.datasources;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * @Description: 动态数据源配置中心
 * @Date: 2019/1/8 11:25
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.second")
//    public DataSource thirdDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.second")
//    public DataSource fourthDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.second")
//    public DataSource fifthDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource,
                                        DataSource secondDataSource
    ) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);

//        DataSource thirdDataSource,
//        DataSource fourthDataSource,
//        DataSource fifthDataSource
//        targetDataSources.put(DataSourceNames.THIRD, thirdDataSource);
//        targetDataSources.put(DataSourceNames.FOURTH, fourthDataSource);
//        targetDataSources.put(DataSourceNames.FIFTH, fifthDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }

}
