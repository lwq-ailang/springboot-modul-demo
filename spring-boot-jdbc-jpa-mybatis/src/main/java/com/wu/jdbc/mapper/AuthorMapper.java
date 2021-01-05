package com.wu.jdbc.mapper;

import com.wu.jdbc.pojo.Author;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 方式三：与MyBatis集成
 * 引入starter：
 * <dependency>
 * <groupId>org.mybatis.spring.boot</groupId>
 * <artifactId>mybatis-spring-boot-starter</artifactId>
 * <version>1.1.1</version>
 * </dependency>
 */
@Mapper
public interface AuthorMapper{

    Long insertAuthor(Author author);

    void updateAuthor(Author author);

    Author queryById(Long id);
}