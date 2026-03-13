package com.first;

sealed class Vehicl permits Car5, Bike5
{
    void type()
    {
        System.out.println("This is a vehicle");
    }
}

final class Car5 extends Vehicl
{
}

final class Bike5 extends Vehicl
{
}

// class ToyVehicle extends Vehicle  // Not allowed

public class Hello2Sealed
{
    public static void main(String[] args)
    {
        Car5 c = new Car5();
        c.type();
        
        Bike5 jj = new Bike5();
        jj.type();
    }
}
