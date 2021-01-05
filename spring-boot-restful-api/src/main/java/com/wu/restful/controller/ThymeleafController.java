package com.wu.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Thymeleaf模板
 * 参考：http://www.ityouknow.com/springboot/2016/05/01/spring-boot-thymeleaf.html
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping(value="/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://www.baidu.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";  
    }

    @RequestMapping(value="/hello")
    public String hello() {
        return "hello";
    }

}