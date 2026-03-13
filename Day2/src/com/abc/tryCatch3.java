package com.abc;

public class tryCatch3 {
	public static void main(String[] args) {

        int balance = 2000;
        int withdrawAmount = 5000;

        if (withdrawAmount > balance) {
            throw new ArithmeticException("Insufficient Balance");
        }

        System.out.println("Transaction Successful");
    }
}
