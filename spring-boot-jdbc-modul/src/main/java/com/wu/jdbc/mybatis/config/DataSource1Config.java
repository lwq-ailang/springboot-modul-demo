package com.wu.jdbc.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * mybatis 导入多数据源
 */
@Configuration
@MapperScan(basePackages = "com.wu.jdbc.mybatis.mapper.test1", //并且给mapper层注入指定的 SqlSessionTemplate
        sqlSessionTemplateRef  = "test1SqlSessionTemplate") //
public class DataSource1Config {

    //创建 DataSource
    @Bean(name = "test1DataSource") //数据源名
    @ConfigurationProperties(prefix = "spring.datasource.test1") //读取数据源配置
    @Primary //声明主数据源
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    //创建 SqlSessionFactory
    @Bean(name = "test1SqlSessionFactory")
    @Primary //声明主数据源
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath:mybatis/mapper/*.xml"));
        return bean.getObject();
    }

    //创建事务
    @Bean(name = "test1TransactionManager")
    @Primary //声明主数据源
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //包装到 SqlSessionTemplate
    @Bean(name = "test1SqlSessionTemplate")
    @Primary //声明主数据源
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}