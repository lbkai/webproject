package com.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/**
 * 将新创建的的Timer改成守护线程
 * @author libokai
 *
 */
public class ThreadTest2 {
public static void main(String[] args){
    System.out.println("当前时间："+new Date());
    Calendar calendar=Calendar.getInstance();
    calendar.add(Calendar.SECOND,10);
    Date date=calendar.getTime();
    
    MyTask task=new MyTask();
    Timer timer=new Timer(true);
    timer.schedule(task,date);
 }
}


