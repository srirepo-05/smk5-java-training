package com.abc;

public class methodOverloadDemo {
    void m1(String s){
        System.out.println("this is the method: "+s);
    }

    void m1(int a){
        System.out.println("this is the method: "+a);
    }

    public static void main(String[] args) {
        methodOverloadDemo demo = new methodOverloadDemo();
        demo.m1("sdfsdf");
        demo.m1(3);

    }

}
