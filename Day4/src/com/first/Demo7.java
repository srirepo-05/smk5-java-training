package com.first;

interface Left {
	default void m1() {
		System.out.println("Left defualt method");
	}
}
interface Right {
	default void m1() {
		System.out.println("Righ defualt method");
	}
}
public class Demo7 implements Left, Right {
	public void m1() {
		Left.super.m1();
	}
	public static void main(String[] args) {
		Demo7 t = new Demo7();
		t.m1();
	}
}
