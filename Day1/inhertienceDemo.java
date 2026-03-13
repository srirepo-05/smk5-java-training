package com.abc;
class GrandParent{
    void m1(){
        System.out.println("this is the method of grand parent class");
    }
}

class Parent1 extends GrandParent{
    void m2(){
        System.out.println("this is the method of parent class");
    }
}


public class inhertienceDemo extends Parent1 {
    void m3(){
        System.out.println("this is the method of child class");
    }

    public static void main(String[] args) {
        inhertienceDemo demo = new inhertienceDemo();
        demo.m1();
        demo.m2();
        demo.m3();
    }


}
