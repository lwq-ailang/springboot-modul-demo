package com.wu.file.controller;

import com.alibaba.fastjson.JSONObject;
import com.wu.file.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志接口:
 */
@RestController
@Scope("prototype")
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 下载日志接口
     * http://127.0.0.1:8088/file/log/download/log_20200218.log
     */
    @GetMapping(value = "/download/{name}")
    public void logDownload(@PathVariable String name, HttpServletResponse response) throws Exception {
        logService.logDownload(name, response);
    }

    /**
     * 上传日志接口
     *
     */
    @PostMapping(value = "/upload")
    public JSONObject logUpload(@RequestParam("file") MultipartFile file) throws Exception {
        return logService.logUpload(file);
    }

    /**
     * 批量上传日志接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/uploads")
    public JSONObject logUploads(HttpServletRequest request) throws Exception {
        return logService.logUploads(request);
    }
}
