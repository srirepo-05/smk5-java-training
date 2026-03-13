package com.first;

interface Calculator
{
	int add(int a, int b);
	static void message()
	{
		System.out.println("thisis static method");
	}
}
class MyCalculator  implements Calculator
{
	public int add(int a, int b) {
         return a+b;
	}
}

public class CaluclatorDemo {
	
	public static void main(String[] args) {
		MyCalculator  c = new MyCalculator();
		int result= c.add(3, 4);
		System.out.println(result);
		Calculator.message();

}
}
