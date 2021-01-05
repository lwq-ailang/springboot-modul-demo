package com.wu.jdbc.service.impl;

import com.wu.jdbc.dao.impl.AuthorDaoJdbcTemplateImpl;
import com.wu.jdbc.mapper.AuthorMapper;
import com.wu.jdbc.pojo.Author;
import com.wu.jdbc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wu
 * @date: 2020/5/28
 * @version: 1.0
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDaoJdbcTemplateImpl authorDao;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<Author> findAuthorList() {
        return authorDao.findAuthorList();
    }

    @Override
    public Author queryById(Long id) {
        return authorMapper.queryById(id);
    }

    @Override
    public void createAuthor(Author author) {
        authorDao.add(author);
    }

}