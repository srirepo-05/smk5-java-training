package com.first;

interface Tests5 {
	void m1(int a, int b);
}
public class Demo5 {
	public static void main(String[] args) {
	Tests5 i = (a,b)->System.out.println("the values of a and b "+(a+b));
	i.m1(2, 3);
	}

}