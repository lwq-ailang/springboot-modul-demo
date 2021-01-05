package com.wu.scheduled.task;

import com.wu.scheduled.util.DateUtils;
import com.wu.scheduled.util.LoggerUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Scheduled默认是不并发执行的
 */
@Component
public class ScheduledTask {

    //@Scheduled(cron = "0/1 * * * * ?") //每1秒执行一次
    public void scheduledTaskByCorn() {
        LoggerUtils.info("定时任务开始 ByCorn：" + DateUtils.dateFormat());
        //System.out.println("定时任务开始 ByCorn：" + DateUtils.dateFormat());
        scheduledTask();
        LoggerUtils.info("定时任务结束 ByCorn：" + DateUtils.dateFormat());
        //System.out.println("定时任务结束 ByCorn：" + DateUtils.dateFormat());

    }

    //@Scheduled(fixedRate = 1000) //每1秒执行一次
    public void scheduledTaskByFixedRate() {
        LoggerUtils.info("定时任务开始 ByFixedRate：" + DateUtils.dateFormat());
        //System.out.println("定时任务开始 ByFixedRate：" + DateUtils.dateFormat());
        scheduledTask();
        LoggerUtils.info("定时任务结束 ByFixedRate：" + DateUtils.dateFormat());
        //System.out.println("定时任务结束 ByFixedRate：" + DateUtils.dateFormat());
    }

    //@Scheduled(fixedDelay = 1000) //每1秒执行一次
    public void scheduledTaskByFixedDelay() {
        LoggerUtils.info("定时任务开始 ByFixedDelay：" + DateUtils.dateFormat());
        //System.out.println("定时任务开始 ByFixedDelay：" + DateUtils.dateFormat());
        scheduledTask();
        LoggerUtils.info("定时任务结束 ByFixedDelay：" + DateUtils.dateFormat());
        //System.out.println("定时任务结束 ByFixedDelay：" + DateUtils.dateFormat());
    }

    private void scheduledTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}