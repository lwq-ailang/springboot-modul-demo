package com.wu.logback.config;


import com.wu.logback.util.StringUtils;

/**
 * Logger 工具类
 */
public class UtilConfig {

    private static String logLevel;

    private static void init() {
        logLevel = "8";
    }

    /**
     * 初始化logLevel=8
     */
    public static String getLogLevel() {
        if (StringUtils.isEmpty(logLevel)) {
            init();
        }
        return logLevel;
    }
}
