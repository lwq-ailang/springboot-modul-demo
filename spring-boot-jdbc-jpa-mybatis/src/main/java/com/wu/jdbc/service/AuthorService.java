package com.wu.jdbc.service;

import com.wu.jdbc.pojo.Author;

import java.util.List;

/**
 * @author: wu
 * @date: 2020/5/28
 * @version: 1.0
 */
public interface AuthorService {

    List<Author> findAuthorList();

    Author queryById(Long id);

    /**
     * 新增一个用户
     */
    void createAuthor(Author author);

}