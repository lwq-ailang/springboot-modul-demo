package com.wu.jdbc.modul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wu.jdbc.modul.*")
public class JdbcModulMain {

    public static void main(String[] args) {
        SpringApplication.run(JdbcModulMain.class,args);
    }
}