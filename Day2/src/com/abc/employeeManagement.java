package com.abc;
import java.util.Scanner;

public class employeeManagement {


    static String[] names = new String[100];
    static int[] ages = new int[100];
    static String[] designations = new String[100];
    static double[] salaries = new double[100];
    static int totalEmployees = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;


        System.out.println("   EMPLOYEE MANAGEMENT SYSTEM \n");



        while (true) {



            System.out.println("1. Create Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");


            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                createEmployee(scanner);
            } else if (choice == 2) {
                displayEmployees();
            } else if (choice == 3) {
                raiseSalary(scanner);
            } else if (choice == 4) {
                System.out.println("\nExiting the program...");
                break;
            } else {
                System.out.println("\nInvalid choice");
            }

        }

        scanner.close();
    }

    static void createEmployee(Scanner scanner) {

        System.out.println("\n--- Create New Employee ---");


        System.out.print("Enter Name: ");
        String name = scanner.nextLine();


        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();


        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();


        System.out.println("\n--- Review Details ---");
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Designation : " + designation);
        System.out.println("Salary      : " + salary);
        System.out.print("Confirm? (y/n): ");

        String confirm = scanner.nextLine();

        if (confirm.equals("y")) {

            names[totalEmployees]        = name;
            ages[totalEmployees]         = age;
            designations[totalEmployees] = designation;
            salaries[totalEmployees]     = salary;
            totalEmployees++;

            System.out.println("\nEmployee created successfully!");
        } else {
            System.out.println("\nEmployee creation cancelled.");
        }

    }


    static void displayEmployees() {

        System.out.println("\n--- All Employees ---");


        if (totalEmployees == 0) {
            System.out.println("No employees found. Please create one first.");
            return;
        }


        for (int i = 0; i < totalEmployees; i++) {
            System.out.println("\nEmployee #" + (i + 1));
            System.out.println("Name        : " + names[i]);
            System.out.println("Age         : " + ages[i]);
            System.out.println("Designation : " + designations[i]);
            System.out.println("Salary      : " + salaries[i]);
            System.out.println("--------------------");
        }

    }


    static void raiseSalary(Scanner scanner) {

        System.out.println("\n--- Raise Salary ---");


        if (totalEmployees == 0) {
            System.out.println("No employees found. Please create one first.");
            return;
        }


        System.out.println("Select an Employee:");
        for (int i = 0; i < totalEmployees; i++) {
            System.out.println((i + 1) + ". " + names[i] + " | Current Salary: $" + salaries[i]);
        }


        System.out.print("Enter Employee Number: ");
        int empNumber = scanner.nextInt();
        scanner.nextLine();


        if (empNumber < 1 || empNumber > totalEmployees) {
            System.out.println("Invalid employee number!");
            return;
        }


        int index = empNumber - 1;

        System.out.println("Employee     : " + names[index]);
        System.out.println("Old Salary   : " + salaries[index]);


        System.out.print("Enter raise amount: $");
        double raiseAmount = scanner.nextDouble();
        scanner.nextLine();


        if (raiseAmount <= 0) {
            System.out.println("Raise amount must be greater than 0!");
            return;
        }


        double oldSalary = salaries[index];
        salaries[index] = oldSalary + raiseAmount;

        System.out.println("\nSalary updated successfully!");
        System.out.println("Employee  : " + names[index]);
        System.out.println("Old Salary: " + oldSalary);
        System.out.println("Raise     : " + raiseAmount);
        System.out.println("New Salary: " + salaries[index]);

    }

}
