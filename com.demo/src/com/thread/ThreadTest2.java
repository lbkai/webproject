package com.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/**
 * ���´����ĵ�Timer�ĳ��ػ��߳�
 * @author libokai
 *
 */
public class ThreadTest2 {
public static void main(String[] args){
    System.out.println("��ǰʱ�䣺"+new Date());
    Calendar calendar=Calendar.getInstance();
    calendar.add(Calendar.SECOND,10);
    Date date=calendar.getTime();
    
    MyTask task=new MyTask();
    Timer timer=new Timer(true);
    timer.schedule(task,date);
 }
}


