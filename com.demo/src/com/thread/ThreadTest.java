package com.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/**
 * 
 * 
 * ������Ȼ�������ˣ������̻�δ���٣��ʺ�ɫ״̬
 * ������Timer��Դ��
 * public Timer() {
    this("Timer-" + serialNumber());
	}
	public Timer(String name) {
    	thread.setName(name);
    	thread.start();
	}
	
	���Կ���ÿ����һ��Timer��������һ���µ��̣߳�
	��ô�������̲߳����ػ��̣߳�����һֱ���С�
	
 * @author libokai
 *
 */
public class ThreadTest {
public static void main(String[] args){
    System.out.println("��ǰʱ�䣺"+new Date());
    Calendar calendar=Calendar.getInstance();
    calendar.add(Calendar.SECOND,10);
    Date date=calendar.getTime();
    
    MyTask task=new MyTask();    
    Timer timer=new Timer();
    timer.schedule(task,date);
   }
}
