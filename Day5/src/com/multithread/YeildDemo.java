package com.multithread;

class MyThread2 extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			Thread.yield();
		}
	}
}
public class YeildDemo {
	public static void main(String[] args) {
MyThread2  t1 = new MyThread2();
MyThread2  t2 = new MyThread2();

t1.setName("Thread -1");
t2.setName("Thread -2");
		
t1.start();
t2.start();
	}
}