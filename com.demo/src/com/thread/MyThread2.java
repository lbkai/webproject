package com.thread;

public class MyThread2 implements Runnable {// ʵ��Runnable�ӿ�

	public void run(){
		System.out.println("������");

	}

	public static void main(String[] args){

		MyThread2 myThread=new MyThread2();
		Thread thread=new Thread(myThread);
		thread.start();
	}
}


