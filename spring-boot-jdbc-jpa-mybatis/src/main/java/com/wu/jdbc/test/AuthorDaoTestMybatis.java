package com.wu.jdbc.test;

import com.wu.jdbc.BootApplicationMain;
import com.wu.jdbc.mapper.AuthorMapper;
import com.wu.jdbc.pojo.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootApplicationMain.class)
public class AuthorDaoTestMybatis {

    @Autowired
    private AuthorMapper mapper;

    @Test
    public void testInsert() {
        Author author = new Author();
        author.setId(9L);
        author.setRealName("唐钰");
        author.setNickName("小宝");
        mapper.insertAuthor(author);
        System.out.println("成功!");
    }

    @Test
    public void testMybatisQuery() {
        Author author = mapper.queryById(1L);
        assertNotNull(author);
        System.out.println(author);
    }

    @Test
    public void testUpdate() {
        Author author = mapper.queryById(2L);
        author.setNickName("月儿");
        author.setRealName("林月如");
        mapper.updateAuthor(author);
    }
}