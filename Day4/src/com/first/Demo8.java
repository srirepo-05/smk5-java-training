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
public class Demo8 implements Left, Right {
	public void m1() {
//		Right.super.m1();
		System.out.println("ovveride method");
	}
	public static void main(String[] args) {
		Demo t = new Demo();
		t.m1();
	}
}

