package com.wu.aop.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 服务类接口
 *
 * @author dukunbiao(null)  2018-09-23
 * https://github.com/dkbnull/SpringBootDemo
 */
public interface IService {

    JSONObject login(Object data) throws Exception;
}
