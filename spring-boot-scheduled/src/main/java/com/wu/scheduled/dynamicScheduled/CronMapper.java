package com.wu.scheduled.dynamicScheduled;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Repository
@Mapper
public interface CronMapper {

    @Select("select cron from cron limit 1")
    public String getCron();

}