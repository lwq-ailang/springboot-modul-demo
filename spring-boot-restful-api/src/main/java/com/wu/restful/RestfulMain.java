package com.wu.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: wu
 * @date: 2020/6/9
 * @version: 1.0
 */
@SpringBootApplication
@ComponentScan("com.wu")
public class RestfulMain {

    public static void main(String[] args) {
        SpringApplication.run(RestfulMain.class);
    }

}