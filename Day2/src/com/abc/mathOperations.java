package com.abc;

public class mathOperations {
    int a = 10;
    int b = 20;

    void add() {
        System.out.println("the sum is: " + (a + b));
    }

    void sub() {
        System.out.println("the sub is: " + (a - b));
    }

    void mul() {
        System.out.println("the mul is: " + (a * b));
    }

    void div() {
        System.out.println("the div is: " + (a / b));
    }

    void factorial() {
        int fact = 1;
        for (int i = 1; i <= a; i++) {
            fact = fact * i;
        }
        System.out.println("the factorial is: " + fact);
    }

    void fibonacci() {
        int n1 = 0, n2 = 1, n3;
        System.out.print("the fibonacci series is: " + n1 + " " + n2 );
        for (int i = 2; i < a; i++) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }

    void areaOfCircle(){
        double area = 3.14 * a * a;
        System.out.println("\nthe area of circle is: "+area);
    }

    void areaOfTriangle(){
        double area = 0.5 * a * b;
        System.out.println("the area of triangle is: "+area);
    }

    public static void main (String[]args){
        mathOperations demo = new mathOperations();
        demo.add();
        demo.sub();
        demo.mul();
        demo.div();
        demo.factorial();
        demo.fibonacci();
        demo.areaOfCircle();
        demo.areaOfTriangle();
    }



}
