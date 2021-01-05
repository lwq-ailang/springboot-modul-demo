package com.wu.jdbc.mybatis;

import com.wu.jdbc.mybatis.mapper.test1.User1Mapper;
import com.wu.jdbc.mybatis.mapper.test2.User2Mapper;
import com.wu.jdbc.mybatis.pojo.UserEntity;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private User1Mapper user1Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    @org.junit.Test
    public void test(){
        List<UserEntity> list = user1Mapper.getAll();
        for (UserEntity userEntity : list) {
            System.out.println(userEntity);
        }
        System.out.println("----------------------------");
        List<UserEntity> entityList = user2Mapper.getAll();
        for (UserEntity userEntity : entityList) {
            System.out.println(userEntity);
        }
    }

}