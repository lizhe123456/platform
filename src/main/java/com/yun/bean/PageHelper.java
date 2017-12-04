package com.yun.bean;

import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class PageHelper {

    @Bean
    public PageHelper pageHelper(DataSource dataSource){
        PageHelper pageHelper = new PageHelper();
        return pageHelper;
    }
}
