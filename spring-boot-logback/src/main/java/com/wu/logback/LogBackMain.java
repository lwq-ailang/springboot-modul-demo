package com.wu.logback;

import com.wu.logback.util.LoggerUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogBackMain {

    public static void main(String[] args) {
        SpringApplication.run(LogBackMain.class, args);
        LoggerUtils.info("日志打印");
    }

}