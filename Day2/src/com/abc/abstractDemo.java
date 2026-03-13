package com.abc;

abstract class Abc
{
	void add()
	{
		System.out.println("additon");
	}
	abstract void div();
}

public class abstractDemo extends Abc {
	
	void div()
	{
		System.out.println("division logic");
	}
	public static void main(String[] args) {
		abstractDemo gg = new abstractDemo();
		gg.add();
		gg.div();
		}

}


