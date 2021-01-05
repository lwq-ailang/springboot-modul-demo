package com.wu.scheduled.task2;

import com.wu.scheduled.util.DateUtils;
import com.wu.scheduled.util.LoggerUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * 动态定时任务
 */
@Component
public class ScheduledTaskV2 implements SchedulingConfigurer {

    @Value("${demo.corn1}")
    private String corn1;

    @Value("${demo.cornV2}")
    private String cornV2;

    private int tag = 0;

    /**
     * 读取配置文件的定时任务
     */
    //@Scheduled(cron = "${demo.corn}")
    public void scheduledTaskByConfig() {
        LoggerUtils.info("定时任务 ByConfig：" + DateUtils.dateFormat());
    }

    /**
     *  动态修改定时任务
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {
            LoggerUtils.info("定时任务：" + DateUtils.dateFormat());
        }, (triggerContext) -> {
            CronTrigger cronTrigger;
            if (tag % 2 == 0) {
                LoggerUtils.info("定时任务==v1==动态修改corn1表达式：" + corn1 + "," + DateUtils.dateFormat());
                cronTrigger = new CronTrigger(corn1);
                tag++;
            } else {
                LoggerUtils.info("定时任务--V2--动态修改corn2表达式：" + cornV2 + "," + DateUtils.dateFormat());
                cronTrigger = new CronTrigger(cornV2);
                tag++;
            }
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }
}
