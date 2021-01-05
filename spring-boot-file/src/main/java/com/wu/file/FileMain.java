package com.wu.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wu.file.*")
public class FileMain {

    public static void main(String[] args) {
        SpringApplication.run(FileMain.class);
    }

}