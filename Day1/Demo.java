package com.abc;

public class Demo {

    public Demo(int a) {
        System.out.println("constrctor");
    }

    void m1(int x) {
        System.out.println("sdfsdf");
    }

    public static void main(String[] args) {
        Demo demo = new Demo(3);
        demo.m1(3);

    }
}