package com.wu.jdbc.dao.impl;

import com.wu.jdbc.dao.AuthorDao;
import com.wu.jdbc.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {

    //与JdbcTemplate集成
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Author author) {
        String sql = "insert into t_author(id,real_name,nick_name) " +
                "values(:id,:realName,:nickName)";
        Map<String, Object> param = new HashMap<>();
        param.put("id", author.getId());
        param.put("realName", author.getRealName());
        param.put("nickName", author.getNickName());
        return (int) jdbcTemplate.update(sql, param);
    }

    @Override
    public int update(Author author) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public Author findAuthor(Long id) {
        return null;
    }

    @Override
    public List<Author> findAuthorList() {
        String sql = "select id,real_name as realName,nick_name as nickName from t_author ";
        Map<String, Object> param = new HashMap<>();
//        return jdbcTemplate.queryForList(sql, param);//查询返回list
        return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper(Author.class));//返回list<Author>
    }
}