package com.multithread;

class TicketBooking
{
    int seats = 1;
   synchronized void bookTicket(String name)
    {
        System.out.println(name + " is trying to book ticket");
        // Block level synchronization
        synchronized(this)
        {
            if(seats > 0)
            {
                System.out.println(name + " successfully booked the ticket");
                seats--;
            }
            else
            {
                System.out.println("Sorry ticket not available for " + name);
            }
        }
    }
}
class Custome extends Thread
{
    TicketBooking tb;
    String name;
    Custome(TicketBooking tb, String name)
    {
        this.tb = tb;
        this.name = name;
    }
    public void run()
    {
        tb.bookTicket(name);
    }
}
public class TrainTicket
{
    public static void main(String args[])
    {
        TicketBooking obj = new TicketBooking();

        Custome c1 = new Custome(obj,"Customer 1");
        Custome c2 = new Custome(obj,"Customer 2");

        c1.start();
        c2.start();
    }
}