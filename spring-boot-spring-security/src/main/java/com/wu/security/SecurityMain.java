package com.wu.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wu.security.*")
public class SecurityMain {

    public static void main(String[] args) {
        SpringApplication.run(SecurityMain.class,args);
    }
}