package com.thread;

public class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("‘À––¡À");

	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		thread.start();

	}

}
