package com.yeb.server;

//启动类

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yeb.server.mapper")
public class YueApplication {
    public static  void  main(String[] args) {
        SpringApplication.run(YueApplication.class,args);
    }
}
