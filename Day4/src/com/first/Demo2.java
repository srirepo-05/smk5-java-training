package com.first;

interface Tests 
{
  public abstract	void m1();
}
class OuterClass
{
	void m2()
	{
		System.out.println("M2 method");
	}
	Tests   t = new Tests() {
		public void m1() {
              System.out.println("Hello world");			
		}
	};
}

public class Demo2 {
  
	 public static void main(String[] args) {
		 OuterClass cc = new OuterClass();
		 cc.m2();
		 cc.t.m1();
	}
	
}
