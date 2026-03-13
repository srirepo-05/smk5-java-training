package com.abc;

import java.util.Scanner;

public class EmployeeManager {
	static String employeeName = null;
	static int employeeAge = 0;
	static String employeeDesignation = null;
	static double employeeSalary = 0.0;

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	    boolean running = true;

	    while (running) {
	        
	        System.out.println("1) Create Employee");
	        System.out.println("2) Display Employee");
	        System.out.println("3) Raise Salary of Employee");
	        System.out.println("4) Exit Application");
	        System.out.print("Enter your choice: ");

	        int choice = scanner.nextInt();
	        scanner.nextLine();

	        switch (choice) {
	            case 1:
	                createEmployee();
	                break;
	            case 2:
	                displayEmployee();
	                break;
	            case 3:
	                raiseSalary();
	                break;
	            case 4:
	                System.out.println("Exiting Application.");
	                running = false;
	                break;
	            default:
	                System.out.println("Inavlid Option");
	                break;
	        }
	    }

	    scanner.close();
	}

	public static void createEmployee() {
	    boolean creatingMore = true; 

	    while (creatingMore) {
	        System.out.println("\n--- Create New Employee ---");

	        System.out.print("Enter employee name: ");
	        employeeName = scanner.nextLine();

	        System.out.print("Enter employee age: ");
	        employeeAge = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Enter employee designation (Programmer/Manager/Tester): ");
	        employeeDesignation = scanner.nextLine().trim();

	        if (employeeDesignation.equalsIgnoreCase("Programmer")) {
	            employeeSalary = 20000.00;
	        } else if (employeeDesignation.equalsIgnoreCase("Manager")) {
	            employeeSalary = 25000.00;
	        } else if (employeeDesignation.equalsIgnoreCase("Tester")) {
	            employeeSalary = 15000.00;
	        } else {
	            System.out.println("Unknown designation");
	            employeeSalary = 0.00;
	        }

	        System.out.println("Employee '" + employeeName + "' created!");
	        System.out.printf("Designation: %s, Initial Salary: $%.2f%n", employeeDesignation, employeeSalary);

	        
	        System.out.print("\nDo you want to create another employee? (y/n): ");
	        String response = scanner.nextLine().trim().toLowerCase();

	        if (!response.equals("y")) {
	            creatingMore = false; 
	        }
	    }
	}

	public static void displayEmployee() {
	    if (employeeName == null) {
	        System.out.println("No employee data. Create an employee first (Option 1).");
	    } else {
	        System.out.println("\n--- Employee Details ---");
	        System.out.println("Name: " + employeeName);
	        System.out.println("Age: " + employeeAge);
	        System.out.println("Designation: " + employeeDesignation);
	        System.out.printf("Salary: $%.2f%n", employeeSalary);
	        
	    }
	}

	public static void raiseSalary() {
	    if (employeeName == null) {
	        System.out.println("No employee to raise salary for. Create an employee first (Option 1).");
	        return;
	    }

	    System.out.print("Enter amount to raise salary for " + employeeName + ": $");
	    double raiseAmount = scanner.nextDouble();
	    scanner.nextLine();

	    employeeSalary += raiseAmount;
	    System.out.printf("Salary for %s raised by $%.2f. New salary: $%.2f%n", employeeName, raiseAmount, employeeSalary);
	}

}
