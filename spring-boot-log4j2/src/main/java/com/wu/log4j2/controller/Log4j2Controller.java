package com.wu.log4j2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4j2Controller {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}