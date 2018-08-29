package com.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/**
 * 
 * 
 * 任务虽然运行完了，但进程还未销毁，呈红色状态
 * 以下是Timer的源码
 * public Timer() {
    this("Timer-" + serialNumber());
	}
	public Timer(String name) {
    	thread.setName(name);
    	thread.start();
	}
	
	可以看出每创建一个Timer就是启动一个新的线程，
	那么启动的线程不是守护线程，所以一直运行。
	
 * @author libokai
 *
 */
public class ThreadTest {
public static void main(String[] args){
    System.out.println("当前时间："+new Date());
    Calendar calendar=Calendar.getInstance();
    calendar.add(Calendar.SECOND,10);
    Date date=calendar.getTime();
    
    MyTask task=new MyTask();    
    Timer timer=new Timer();
    timer.schedule(task,date);
   }
}
