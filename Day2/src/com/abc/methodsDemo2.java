package com.abc;

public class methodsDemo2 {
	
	void m1() {
		this.m2();
		System.out.println("I am methos 1");
	}

	void m2() {
		System.out.println("I am method 2");
	}

	public static void main(String[] args) {
		methodsDemo gg = new methodsDemo();
		gg.m1();
	}
}
