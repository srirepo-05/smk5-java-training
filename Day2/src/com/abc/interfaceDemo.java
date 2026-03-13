package com.abc;

interface it1 {
	abstract void add();

	abstract void div();

}

public class interfaceDemo implements it1 {
	
	public void add() {
		System.out.println("addition logic");
	}

	public void div() {
		System.out.println("Division logic");
	}

	public static void main(String[] args) {
		interfaceDemo gg = new interfaceDemo();
		gg.add();
		gg.div();
	}

}
