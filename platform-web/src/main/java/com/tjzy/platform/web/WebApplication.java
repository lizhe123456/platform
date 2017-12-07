package com.tjzy.platform.web;

import com.tjzy.platform.model.constant.Constant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@ServletComponentScan
@SpringBootApplication(scanBasePackages = {Constant.BASE_PACKAGE})
public class WebApplication extends WebMvcConfigurerAdapter{

    public static void main(String[] args){
        System.out.println("------------SpringBoot开始启动------------------");
        SpringApplication.run(WebApplication.class,args);
        System.out.println("------------SpringBoot启动完成------------------");
    }
}
