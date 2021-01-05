package com.wu.jdbc.jpa.service;

import com.wu.jdbc.jpa.pojo.UserDetail;
import com.wu.jdbc.jpa.pojo.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {

    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);

}
