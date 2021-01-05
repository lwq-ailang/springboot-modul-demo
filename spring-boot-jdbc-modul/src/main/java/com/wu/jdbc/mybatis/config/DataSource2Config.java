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
@MapperScan(basePackages = "com.wu.jdbc.mybatis.mapper.test2", //并且给mapper层注入指定的 SqlSessionTemplate
        sqlSessionTemplateRef  = "test2SqlSessionTemplate") //
public class DataSource2Config {

    //创建 DataSource
    @Bean(name = "test2DataSource") //数据源名
    @ConfigurationProperties(prefix = "spring.datasource.test2") //读取数据源配置
    //@Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    //创建 SqlSessionFactory
    @Bean(name = "test2SqlSessionFactory")
    //@Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath:mybatis/mapper/*.xml"));
        return bean.getObject();
    }

    //创建事务
    @Bean(name = "test2TransactionManager")
    //@Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //包装到 SqlSessionTemplate
    @Bean(name = "test2SqlSessionTemplate")
    //@Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}