package com.abc;

abstract class Abc
{
	abstract void add();
	abstract void div();
}
abstract class Abcd extends Abc
{
	void add()
	{
		System.out.println("addtion logic");
	}
}

public class abstractDemo2 extends Abcd {
	
	void div()
	{
		System.out.println("Division logic");
	}
	public static void main(String[] args) {
		abstractDemo2 gg = new abstractDemo2();
		gg.add();
		gg.div();
		}

}
