package com.multithread;

class MyThreads extends Thread {
	public void run() {
		for (int i = 0; i <=5; i++) {
			System.out.println("Thread is running: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class Demo2 {

	public static void main(String[] args) {
		MyThreads t1 = new MyThreads();
		System.out.println("Before Starting: " + t1.isAlive());
		t1.start();
		System.out.println("After Starting: " + t1.isAlive());
		try {
			t1.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("After Stopping: " + t1.isAlive());
	}
}
