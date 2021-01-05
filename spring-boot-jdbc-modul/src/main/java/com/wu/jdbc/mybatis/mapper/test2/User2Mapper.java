package com.wu.jdbc.mybatis.mapper.test2;

import com.wu.jdbc.mybatis.pojo.UserEntity;

import java.util.List;

public interface User2Mapper {
	List<UserEntity> getAll();
	UserEntity getOne(Long id);
	void insert(UserEntity user);
	void update(UserEntity user);
	void delete(Long id);
}