package com.yun.config;

import org.springframework.boot.CommandLineRunner;

public class MyStartupRun implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行");
    }
}
