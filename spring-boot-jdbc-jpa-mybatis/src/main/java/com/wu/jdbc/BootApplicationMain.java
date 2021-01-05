package com.wu.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wu.jdbc.config")//扫描数据源
@MapperScan("com.wu.jdbc.mapper")
public class BootApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(BootApplicationMain.class, args);
    }

}