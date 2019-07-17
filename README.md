定时任务调度Timer和Quartz的用法详解

timer的 schedule 方法和重载方法的解读：

1、schedule（task，time）  task：所要安排的任务   time ：执行任务的时间
作用：在时间等于或者超过time的时候执行且仅执行一次task

2、schedule(task,delay,period);
作用：当前时间的delay秒后开始执行 myTimerTask 里面的run方法，之后每隔period秒执行一次

3、schedule(task,delay)  delay:执行任务前的毫秒数
作用：在当前时间的delay毫秒后开始执行任务且只执行一次

4、scheduleAtFixedRate（task，time，period） time：首次执行任务的时间
作用：时间等于或者超过time的时间开始执行任务，之后每period间隔后循环执行任务

5、scheduleAtFixedRate（task，delay，period）delay：执行任务前的延时时间


其他常用的函数：
TimerTask 的两个常用的函数： cancel（） ：作用：取消当前TimerTask下面的任务
scheduledExecutionTime 作用： 返回此任务实际执行的已安排执行的时间 返回的类型是long

Timer的其他函数  cancel（）作用：终止此计时器，结束所有的任务

purge（） 作用：从此计时器的任务队列中移除所用的已取消的任务 返回值是队列中移除的任务数


schedule与scheduleAtFixedRate 的区别：
1、首次计划执行的时间早于当前的时间
    schedule方法：  第一次时间被delay  那实际时间就按执行的时间计算
    scheduleAtFixedRate 
2、任务执行所需的时间超过任务的执行周期的间隔（任务的执行时间间隔是2秒，但是一次任务需要三秒才能执行完毕）


*******************************************************************************************************
Quartz

Job： 只有一个方法  excute 相当于是TimerTask 中的run方法 在里面编写业务逻辑
       在quartz中的生命周期  每次调用excute方法会创建一个新的实例，调用完成后实例会被删除 被垃圾回收机制回收

JobDetail ：为job实例提供了许多的设置属性 ，以及jobDataMap 成员变量属性 ，它是用来存储特定的job实例的状态信息，
            调度器也是需要借助jobDetail对象来添加job实例
            

CronTrigger : 作用 基于日历的作业调度器（可以设定与某个星期去执行任务，或者某一天）
Cron表达式 ：用于配置CronTrigger实例
            是有七个字表达式组成的字符串，描述了时间表的详细的信息
            格式 ：[秒] [分] [小时] [日] [月][周] [年] 


