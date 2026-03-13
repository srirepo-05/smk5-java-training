package com.first;

abstract class A {
	abstract void m1();
}

public class Demo1 {
	A a = new A() {
		void m1() {
			System.out.println("m1 method implementation");
		}
	};
	
	public static void main(String[] args) {
		Demo1 demo = new Demo1();
		demo.a.m1();
	}

}
