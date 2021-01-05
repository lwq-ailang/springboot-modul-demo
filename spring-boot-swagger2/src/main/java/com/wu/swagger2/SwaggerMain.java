package com.wu.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.wu.swagger2.*")
@EnableSwagger2
public class SwaggerMain {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerMain.class);
    }

}