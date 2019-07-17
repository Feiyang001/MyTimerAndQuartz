package com.guohui.project.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzJob implements Job {

    //编写相应的业务逻辑
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //打印当前的时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("当前的执行时间是："+simpleDateFormat.format(date));
        System.out.println("Hello world!!");

        //jobDataMap存储在jobExecutionContext中
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        System.out.println("jobDetail 的name和group："+key.getName()+";"+key.getGroup());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap jobDataMap1 = jobExecutionContext.getTrigger().getJobDataMap();

        System.out.println(jobDataMap.getString("message"));
        System.out.println(jobDataMap1.getString("message"));

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("trigger 的name和group："+triggerKey.getName()+";"+triggerKey.getGroup());

        /*
        这个方法是合并jobDetail和trigger中的信息的map  如果两个中的key相同则或发生覆盖，优先打印trigger中的信息
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        String message = dataMap.getString("message");
        System.out.println(message);
        */


    }

}
