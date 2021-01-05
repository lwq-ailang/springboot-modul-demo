package com.wu.mybatis.mapper;

import com.wu.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper//指定这是一个操作数据库的mapper（二选其一）
public interface UserMapper {

    int insertUser(User user);

    int deleteUser(User user);

    int updateUser(User user);

    User getUser(Integer userId);

    int getUserCount(@Param("userCondition") User userCondition);

    List<User> getUserList(@Param("userCondition") User userCondition, @Param("roeIndex") int row, @Param("pageSize") int pageSize);

    @Select("select id,name from User")
    List<User> select();

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex" ),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex" ),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
