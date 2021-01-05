package com.wu.aop.common;

import com.alibaba.fastjson.JSONObject;
import com.wu.aop.model.ReturnMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器，用户处理捕捉到的异常
 */
@RestControllerAdvice //定义统一的异常处理类
public class GlobalExceptionHandler {

    //用来定义函数针对的异常类型,根据抛出的具体Exception类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理。
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JSONObject exceptionHandler(HttpServletRequest request, Exception e) {
        return ReturnMessage.createReturnMessage("4000", e.getMessage());
    }

}