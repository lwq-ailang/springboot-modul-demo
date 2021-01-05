package com.wu.aop.controller;

import com.wu.aop.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 控制器基类
 */
public class BaseController {

    @Autowired
    protected BaseService baseService;

}
