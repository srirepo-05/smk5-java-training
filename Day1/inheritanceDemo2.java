package com.abc;

class GrandParents{
    void m1(){
        System.out.println("this is the method of grand parent class");
    }}
class Family extends GrandParents{
    void m2(){
        System.out.println("this is the method of family class");
    }
}


public class inheritanceDemo2 extends GrandParents {
    void m3(){
        System.out.println("this is the method of child class");
    }

    public static void main(String[] args) {
        inheritanceDemo2 demo = new inheritanceDemo2();
        demo.m1();
        demo.m3();
    }
}
