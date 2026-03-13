package com.arraylist;

import java.util.ArrayList;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		arrayList.add("C");
		arrayList.add("A");
		arrayList.add("E");
		arrayList.add("D");
		arrayList.add("F");
		arrayList.add(new Integer(101));
		arrayList.add(null);
		arrayList.add("A");
		System.out.println(arrayList);
		arrayList.add(3, "B");
		System.out.println(arrayList);
		String s1 = (String) arrayList.get(3);
		System.out.println("sdf  " + s1);
		arrayList.remove("F");
		System.out.println(arrayList);
		arrayList.remove(1);
		System.out.println(arrayList);
		
	}

}
