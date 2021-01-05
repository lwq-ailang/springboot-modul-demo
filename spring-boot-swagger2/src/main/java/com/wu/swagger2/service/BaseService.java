package com.wu.swagger2.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务类路由
 */
@Service
public class BaseService implements IService {

    @Autowired
    private LoginService loginService;

    @Override
    public JSONObject login(Object data) throws Exception {
        return loginService.login(data);
    }
}
