package com.wu.swagger2.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 服务类接口
 */
public interface IService {

    JSONObject login(Object data) throws Exception;
}
