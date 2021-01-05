package com.wu.jdbc.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wu.jdbc.jpa.*")
public class JdbcModulMain {

    public static void main(String[] args) {
        SpringApplication.run(JdbcModulMain.class,args);
    }
}