package com.first;



interface Tests4 {
	int m1(int x);
}

public class Demo4 {
	public static void main(String[] args) {
		Tests4 i = x -> x * x;
		System.out.println("the square " + i.m1(5));
	}

}