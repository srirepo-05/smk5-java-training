package com.abc;

public class tryCatch {
	
	public static void main(String[] args) {
		System.out.println("Hello");
		try {
			System.out.println(10 / 0);
		} 
		
		catch (Exception e) {
			System.out.println("exception reasied");
		}
		
		System.out.println("Hello last statment");
	}

}
