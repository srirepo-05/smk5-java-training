package com.abc;

public class thisDemo {
	int a = 10;
	int b = 20;

	void m1(int a, int b) {
		System.out.println(a + b);
		System.out.println(this.a + this.b);
	}

	public static void main(String[] args) {
		thisDemo gg = new thisDemo();
		gg.m1(2, 3);
	}
}
