package com.yeb.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @author EL Zhang 
 */
@SpringBootApplication
@MapperScan("com.yeb.server.mapper")
@EnableScheduling
public class YueApplication {
    public static  void  main(String[] args) {
        SpringApplication.run(YueApplication.class,args);
    }
}
