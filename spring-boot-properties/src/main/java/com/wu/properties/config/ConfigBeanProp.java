package com.wu.properties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component //表示将该类标识为Bean
@ConfigurationProperties(prefix = "demo") //用于绑定属性，其中prefix表示所绑定的属性的前缀。
@PropertySource(value = "config.properties") //表示配置文件路径。
public class ConfigBeanProp {

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}