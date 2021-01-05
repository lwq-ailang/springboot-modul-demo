package com.wu.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class PropertiesConfig {

    @Value("${demo.name}")
    private String name;

    @Value("${demo.age}")
    private String age;

    public String getNameAndAge(){
        return "get properties value by ''@Value'' :" +
                //1、使用@Value注解读取
                " name=" + name +
                " , age=" + age;
    }
}