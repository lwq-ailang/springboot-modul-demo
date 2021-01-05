package com.wu.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@ComponentScan("com.wu.scheduled.staticScheduled") //静态定时任务
//@ComponentScan("com.wu.scheduled.dynamicScheduled") //动态定时任务
//@ComponentScan("com.wu.scheduled.threadScheduled") //线程定时任务
//@ComponentScan("com.wu.scheduled.task") //定时任务
//@ComponentScan("com.wu.scheduled.task2") //动态修改定时任务
@ComponentScan("com.wu.scheduled.task3") //并发执行定时任务
public class ScheduledMain {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledMain.class);
    }

}