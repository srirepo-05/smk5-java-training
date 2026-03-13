package com.abc;

interface it2 {
	abstract void add();
	abstract void div();
}

abstract class Abcde implements it2 {
	public void add() {
		System.out.println("addition logic");
	}
}

public class interfaceDemo2 {
	
	public void div() {
		System.out.println("divison logic");
	}

	public static void main(String[] args) {
		interfaceDemo2 gg = new interfaceDemo2();
		gg.add();
		gg.div();
	}

}
