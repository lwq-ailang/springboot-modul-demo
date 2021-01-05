package com.wu.jdbc.dao;

import com.wu.jdbc.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 方式二：与JPA集成
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query("select user from com.wu.jdbc.pojo.User user where id=:userId")
    public Optional<User> findByUserId(Long userId);

    @Query("select user from com.wu.jdbc.pojo.User user where nick_name=:nickName")
    public List<User> queryByNickName(@Param("nickName") String nickName);

}