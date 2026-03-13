package com.abc;

class Parent {
    void m1() {
        System.out.println("this is the method of parent class");
    }
}

public class methodOverrideDemo extends Parent {
        void m1(){
            System.out.println("this is the method of child class");
        }

        public static void main(String[] args) {
            methodOverrideDemo demo = new methodOverrideDemo();
            demo.m1();
        }

    }





