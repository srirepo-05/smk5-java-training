package com.first;

record Studenty(int id,String name,int marks) {
	public class DemoRecord2 {
		
		public static void main(String[] args) {
		Studenty s = new Studenty(1, "Anand", 90);
		
		System.out.println(s.id());
		System.out.println(s.name());
		System.out.println(s.marks());
		

	}
	
	
}


