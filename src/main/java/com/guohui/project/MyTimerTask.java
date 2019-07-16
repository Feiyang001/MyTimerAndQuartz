package com.guohui.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;


public class MyTimerTask extends TimerTask {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTimerTask(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        //设置日期的格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //打印当前的时间
        System.out.println("我是:"+name+";当前的时间是："+sf.format(new Date()));
    }
}
