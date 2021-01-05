package com.wu.redis.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RedisMain {

    public static void main(String[] args) {
        SpringApplication.run(RedisMain.class,args);
    }
}