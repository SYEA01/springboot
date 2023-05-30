package com.example.springboot.config;

import com.example.springboot.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    //要定义一个工作明细和触发器。再通过调度器把触发器绑定工作明细，工作明细中指定工作

    /**
     * 工作明细，绑定具体的工作
     *
     * @return
     */
    @Bean
    public JobDetail printJobDetail() {
        return JobBuilder.newJob(MyQuartz.class)  // 绑定具体的工作
                .storeDurably()  // 如果没有使用这个工作，是否要持久化
                .build();
    }

    /**
     * 触发器，绑定对应的工作明细
     *
     * @return
     */
    @Bean
    public Trigger printJobTrigger() {
        ScheduleBuilder<? extends Trigger> schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");  //  秒 分 时 日 月 星期  (如果星期写？，代表根据前面的日月匹配星期)
        return TriggerBuilder.newTrigger()
                .withSchedule(schedBuilder)  // 设定时间
                .forJob(printJobDetail())  // 指定哪个工作明细
                .build();
    }
}
