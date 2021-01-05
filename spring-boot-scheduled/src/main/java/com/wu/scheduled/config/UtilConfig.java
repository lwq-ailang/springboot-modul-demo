package com.wu.scheduled.config;

import com.wu.scheduled.util.StringUtils;

/**
 * Logger 工具类 ：https://github.com/dkbnull/Util
 */
public class UtilConfig {

    private static String logLevel;

    private static void init() {
        logLevel = "8";
    }

    public static String getLogLevel() {
        if (StringUtils.isEmpty(logLevel)) {
            init();
        }
        return logLevel;
    }
}
