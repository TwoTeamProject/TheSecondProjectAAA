package com.pro.two;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * className:com.pro.two.SpringBootMainApp
 * discription:
 * author:sjq
 * createTime:2018-11-27 20:50
 */
@SpringBootApplication
@MapperScan("com.pro.two.dao")
public class SpringBootMainApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApp.class);
    }
}
