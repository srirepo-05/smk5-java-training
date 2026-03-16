package com.multithread;

class MyThread3 extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() +
				" --Is running with --" + Thread.currentThread().getPriority());
	}
}

public class PriorityDemo {
	public static void main(String[] args) {
		MyThread3 t1 = new MyThread3();
		MyThread3 t2 = new MyThread3();
		MyThread3 t3 = new MyThread3();

		t1.setName("Low Priority");
		t2.setName("Normal Priority");
		t3.setName("High Priority");

		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();
		t3.start();

	}
}
