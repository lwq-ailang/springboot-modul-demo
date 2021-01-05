package com.wu.properties.controller;

import com.wu.properties.config.ConfigBeanProp;
import com.wu.properties.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Autowired
    private Environment environment;

    @Autowired
    private ConfigBeanProp configBeanProp;

    @RequestMapping("/get")
    public String getNameAndAge(){
        //2、使用Environment读取
        String x = " ,<p> sex=" + environment.getProperty("demo.sex") +
                " , address=" + environment.getProperty("demo.address");
        //3、使用@ConfigurationProperties注解读取
        String y = "<p>get properties value by ''@ConfigurationProperties'' :" +
                " phone=" + configBeanProp.getPhone() ;
        return propertiesConfig.getNameAndAge()+x+y;
    }
}