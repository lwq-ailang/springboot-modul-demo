package com.wu.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 参考：https://github.com/dkbnull/SpringBootDemo
 */
@SpringBootApplication
@MapperScan("com.maven.generator.dao")
public class GeneratorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorDemoApplication.class, args);
    }

}
