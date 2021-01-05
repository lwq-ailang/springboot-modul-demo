package com.wu.jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/20 0020.
 * Druid 数据源配置类
 */
@Configuration
public class DruidConfig {
    /**
     * 1.将自定义的 Druid 数据源添加到容器中，不再让 Spring Boot 自动创建
     * 这样做的目的是：绑定全局配置文件中的 druid 数据源属性到 com.alibaba.druid.pool.DruidDataSource
     * 从而让它们生效
     *
     * @ConfigurationProperties(prefix = "spring.datasource")：
     * 作用就是将全局配置文件中前缀为 spring.datasource的属性值注入到 com.alibaba.druid.pool.DruidDataSource 的同名参数中
     * 参考：《Spring Boot 全局配置文件》：https://blog.csdn.net/wangmx1993328/article/details/80998758
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 2.配置 Druid 监控之管理后台的 Servlet：
     * 内置Servler容器时没有web.xml文件，所以使用SpringBoot的注册Servlet方式
     * 配置一个管理后台的 Servlet，因为使用的是内置 Servlet 容器，
     * 所以可以参考《Web项目tiger之12注册Servlet三大组件之Servlet》：https://blog.csdn.net/wangmx1993328/article/details/81583834
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //loginUsername：Druid 后台管理界面的登录账号
        //loginPassword：Druid 后台管理界面的登录密码
        //allow：Druid 后台允许谁可以访问
        //     initParams.put("allow", "localhost")：表示只有本机可以访问
        //     initParams.put("allow", "")：为空或者为null时，表示允许所有访问
        //deny：Druid 后台拒绝谁访问
        //     initParams.put("deny", "192.168.1.20");表示禁止此ip访问
        //
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "");
        /*initParams.put("deny", "192.168.1.20");*/
        /** 设置初始化参数*/
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 3.配置 Druid 监控 之 web 监控的 filter
     * WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        /** exclusions：设置哪些请求进行过滤排除掉，从而不进行统计*/
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        /** "/*" 表示过滤所有请求*/
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}