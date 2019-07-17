package com.guohui.project.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzScheduler {

    public static void main(String[] args) throws SchedulerException {
        //创建一个jobdetail实例 并与job实例绑定
        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class).withIdentity("myjob","group")
                .usingJobData("message","你好啊！！存储在jobDetail中的信息").build();
        //创建一个trigger实例 ,定义job立刻执行，并且每个两秒执行一次
        SimpleTrigger trigger  = TriggerBuilder.newTrigger()
                .withIdentity("mytrigger","group1")
                .usingJobData("message","这个是存在trigger中的参数")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(2).repeatForever())
                .build();
        //创建schedule实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("当前的时间是："+simpleDateFormat.format(date));

        scheduler.scheduleJob(jobDetail,trigger);

        /*
        CronTrigger 的使用方法

        CronTrigger trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger","group2")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("* * * * * ? *")//* * * * * ? * 代表的是每秒都执行
                )
                .build();
        scheduler.scheduleJob(jobDetail,trigger1);
        */


    }
}
