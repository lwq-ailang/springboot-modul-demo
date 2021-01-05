package com.wu.jdbc.test;

import com.wu.jdbc.BootApplicationMain;
import com.wu.jdbc.dao.AuthorDao;
import com.wu.jdbc.pojo.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootApplicationMain.class) //通过springboot启动
public class AuthorDaoTest {

    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testInsert() {
        Author author = new Author();
        author.setRealName("5");
        author.setNickName("5");
        authorDao.add(author);
        System.out.println("插入成功！");
    }
}