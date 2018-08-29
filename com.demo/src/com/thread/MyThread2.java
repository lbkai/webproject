package com.thread;

public class MyThread2 implements Runnable {// 实现Runnable接口

	public void run(){
		System.out.println("运行了");

	}

	public static void main(String[] args){

		MyThread2 myThread=new MyThread2();
		Thread thread=new Thread(myThread);
		thread.start();
	}
}


