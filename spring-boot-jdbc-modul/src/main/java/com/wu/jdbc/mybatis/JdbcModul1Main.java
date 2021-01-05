package com.wu.jdbc.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wu.jdbc.mybatis.*")
public class JdbcModul1Main {

    public static void main(String[] args) {
        SpringApplication.run(JdbcModul1Main.class,args);
    }
}