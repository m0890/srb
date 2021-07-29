package com.atguigu.srb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.srb.mybatisplus.mapper")
public class Srb {

    public static void main(String[] args) {
        SpringApplication.run(Srb.class,args);
    }
}
