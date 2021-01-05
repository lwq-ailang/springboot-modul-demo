package com.wu.mybatis.controller;

import com.wu.mybatis.entity.User;
import com.wu.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String getUser(@PathVariable Integer id) {
        return userService.getUser(id).toString();
    }

    @RequestMapping("/findAll")
    public List<User> findAll(@RequestBody(required = false) User user, int row, int pageSize) {
        if (row == 0){
            row = 1;
        }
        if (pageSize == 0){
            pageSize = 10;
        }
        return userService.getUserList(user, row, pageSize);
    }

}
