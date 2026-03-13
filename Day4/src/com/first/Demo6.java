package com.first;

interface Vehicle {
	void start();
	default void m1()
	{
		System.out.println("default method");
	}
}
class Car implements Vehicle {
	public void start() {
		System.out.println("car starts");
	}
}
public class Demo6 {
	public static void main(String[] args) {
		Car vv = new Car();
		vv.start();
		vv.m1();
	}
}

