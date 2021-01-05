package com.wu.aop.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

/**
 * https://github.com/dkbnull/SpringBootDemo
 */
@RestController
@Scope("prototype")
public class LoginController extends BaseController {

    @PostMapping(value = "/login")
    public JSONObject login(
            @RequestParam(value = "sign") String sign,
            @RequestParam(value = "timestamp") String timestamp,
            @RequestParam(value = "data") String data
    ) throws Exception {
        return baseService.login(data);
    }

    @RequestMapping(value = "/get" , method = {RequestMethod.POST})
    public String get( @RequestBody String name){
        System.out.println("in");
        return name;
    }
}
