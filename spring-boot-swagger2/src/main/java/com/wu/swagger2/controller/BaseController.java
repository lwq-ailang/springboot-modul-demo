package com.wu.swagger2.controller;

import com.wu.swagger2.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 控制器基类
 */
public class BaseController {

    @Autowired
    protected BaseService baseService;
}
