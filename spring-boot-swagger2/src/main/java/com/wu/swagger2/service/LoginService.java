package com.wu.swagger2.service;

import com.alibaba.fastjson.JSONObject;
import com.wu.swagger2.util.JSONUtils;
import org.springframework.stereotype.Service;

/**
 * 登录接口服务类
 */
@Service
public class LoginService {

    public JSONObject login(Object data) throws Exception {
        JSONObject responseParams = new JSONObject();
        JSONObject requestParams = JSONObject.parseObject(data.toString());
        if (JSONUtils.getJSONString(requestParams, "username").equalsIgnoreCase(
                JSONUtils.getJSONString(requestParams, "password"))) {
            responseParams.put("code", "1000");
            responseParams.put("message", "SUCCESS");
        } else {
            responseParams.put("code", "2000");
            responseParams.put("message", "FAIL");
        }

        return responseParams;
    }
}
