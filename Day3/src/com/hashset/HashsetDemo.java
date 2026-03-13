package com.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashsetDemo {
	
public static void main(String[] args) {
		
		// create a HashSet
		HashSet set = new HashSet();
 
		System.out.println("1.Initial size of HashSet before adding elements: "	+ set.size());
		System.out.println("2.HashSet is empty before adding values: "	+ set.isEmpty());
		System.out.println("3.Contents of HashSet before adding values: " + set);
		
 
		// adding elements or values to the HashSet
		set.add("C");
		set.add("A");
		set.add("E");
		set.add("B");
		// cannot add duplicates, dissimilar and null values in HashSet
		set.add("D");
		set.add("F");
		//	set.add("A");
		//	set.add(new Integer(10));
		//	set.add(null);
		System.out.println("4.Size of HashSet after adding elements: " + set.size());
		System.out.println("5.HashSet is empty after adding values: " + set.isEmpty());
		//Display the contents of HashSet
		System.out.println("6.Contents of HashSet after adding values: " + set);
		//check whether an element is present or not
		boolean b1 = set.contains("E");
		System.out.println("7.Value E is present: " + b1);
		boolean b2 = set.contains("R");
		System.out.println("8.Value R is present: " + b2);
		//Remove an element from the HashSet
		set.remove("B");
		System.out.println("9.Size of HashSet after deletion: " + set.size());
		System.out.println("10.Contents of HashSet after deletion: " + set);
		//delete all the elements in the HashSet
		set.clear();
		System.out.println("11.Size of HashSet after clearing: " + set.size());
		System.out.println("12.Contents of HashSet after clearing: " + set);
		//using iterator with HashSet
		
		System.out.println("\n--- Iterating through HashSet with Iterator ---");
		System.out.print("Elements via Iterator: ");
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Object element = iterator.next();
			System.out.print(element + " ");
		}
	}

}
