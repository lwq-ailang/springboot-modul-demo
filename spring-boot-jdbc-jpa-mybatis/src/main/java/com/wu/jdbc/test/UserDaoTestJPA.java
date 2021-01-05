package com.wu.jdbc.test;

import com.wu.jdbc.BootApplicationMain;
import com.wu.jdbc.dao.UserDao;
import com.wu.jdbc.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

/**
 * @author: wu
 * @date: 2020/5/28
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootApplicationMain.class)
public class UserDaoTestJPA {

    @Autowired
    private UserDao userDao;

    @Test
    public void testQuery() {
        List<User> userList = userDao.queryByNickName("疯子");
        assertTrue(userList.size() > 0);
        System.out.println(userList);
    }

    @Test
    public void testfindByUserId() {
        Optional<User> userId = userDao.findByUserId(2L);
        System.out.println(userId);
    }

}