package com.first;

interface Tests1
{
	void m1();
}

public class Demo3 {
	public static void main(String[] args) {
		Tests1 t = () -> {
				System.out.println("Hello world");
			}
		t.m1();
		};
		
}
