package com.first;

import java.util.Arrays;
import java.util.List;

public class StreamApi {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,6);
		
		// Using Stream API to filter even numbers and print them
		numbers.stream()
		       .filter(n -> n % 2 == 0)
		       .map(n->n*2)
		       .forEach(n -> System.out.println("Even number: " + n));
	
	}

}
