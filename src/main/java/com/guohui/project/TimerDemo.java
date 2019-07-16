package com.guohui.project;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class TimerDemo {

    public static void main(String[] args) {

        //创建timer实例
        Timer t = new Timer();
        //创建一个timertask
        MyTimerTask myTimerTask = new MyTimerTask("No.1");
        //当前时间的2秒后开始执行 myTimerTask 里面的run方法，之后每隔三秒执行一次
        t.schedule(myTimerTask,2000L,3000L);

        /**
         * 获取当前的时间，并在当前的时间上加三秒
         * 在时间等于或者超过time的时候执行且仅执行一次task
         */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sf.format(calendar.getTime());
        calendar.add(Calendar.SECOND,3);
        myTimerTask.setName("我是2号");
        t.schedule(myTimerTask,calendar.getTime());


    }
}
