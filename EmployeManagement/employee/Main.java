package com.employee;

import java.util.Scanner;

public class Main {

    static String[] names        = new String[100];
    static int[]    ages         = new int[100];
    static String[] designations = new String[100];
    static double[] salaries     = new double[100];
    static int totalEmployees    = 0;

    static class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

  
    static class InvalidPercentageException extends Exception {
        public InvalidPercentageException(String message) {
            super(message);
        }
    }

    
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    
    static class NoEmployeesException extends Exception {
        public NoEmployeesException(String message) {
            super(message);
        }
    }

    
    static class InvalidDesignationException extends Exception {
        public InvalidDesignationException(String message) {
            super(message);
        }
    }


    static double getDefaultSalary(String designation) throws InvalidDesignationException {

        double employeeSalary;

        if (designation.equalsIgnoreCase("Programmer")) {
            employeeSalary = 20000.00;
        } else if (designation.equalsIgnoreCase("Manager")) {
            employeeSalary = 25000.00;
        } else if (designation.equalsIgnoreCase("Tester")) {
            employeeSalary = 15000.00;
        } else {
            
            throw new InvalidDesignationException(
                "\"" + designation + "\" is not a valid designation!\n" +
                "  Valid roles are: Programmer, Manager, Tester"
            );
        }

        return employeeSalary;
    }

 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("==================================");
        System.out.println("   EMPLOYEE MANAGEMENT SYSTEM    ");
        System.out.println("==================================");

        while (true) {

            System.out.println("\n------ MENU ------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display Last Employee");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");
            System.out.println("------------------");
            System.out.print("Enter your choice: ");

            try {
                String choiceInput = scanner.nextLine();
                if (!choiceInput.matches("[0-9]+")) {
                    throw new InvalidInputException("Menu choice must be a number!");
                }
                choice = Integer.parseInt(choiceInput);
            } catch (InvalidInputException e) {
                System.out.println("\n[Error] " + e.getMessage());
                continue;
            }

            if (choice == 1) {
                createEmployee(scanner);
            } else if (choice == 2) {
                try {
                    displayLastEmployee();
                } catch (NoEmployeesException e) {
                    System.out.println("\n[Error] " + e.getMessage());
                }
            } else if (choice == 3) {
                try {
                    raiseSalary(scanner);
                } catch (NoEmployeesException e) {
                    System.out.println("\n[Error] " + e.getMessage());
                }
            } else if (choice == 4) {
                System.out.println("\nGoodbye! Exiting the program...");
                break;
            } else {
                System.out.println("\nInvalid choice! Please enter 1, 2, 3 or 4.");
            }

        }

        scanner.close();
    }

 
    static void createEmployee(Scanner scanner) {

        System.out.println("\n--- Create New Employee ---");

        
        String name = "";
        while (true) {
            System.out.print("Enter Name (max 2 spaces allowed): ");
            name = scanner.nextLine();
            try {
               
                int spaceCount = 0;
                for (int i = 0; i < name.length(); i++) {
                    if (name.charAt(i) == ' ') {
                        spaceCount++;
                    }
                }

                if (name.trim().isEmpty()) {
                    throw new InvalidNameException("Name cannot be empty!");
                }

                if (spaceCount > 2) {
                    throw new InvalidNameException(
                        "Name can only have up to 2 spaces! You entered " + spaceCount + " spaces."
                    );
                }

                break;

            } catch (InvalidNameException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }

        
        int age = 0;
        while (true) {
            System.out.print("Enter Age (19-60): ");
            String ageInput = scanner.nextLine();
            try {
                if (!ageInput.matches("[0-9]+")) {
                    throw new InvalidInputException("Age must be a number!");
                }

                age = Integer.parseInt(ageInput);

                if (age < 19 || age > 60) {
                    throw new InvalidAgeException(
                        "Age must be between 19 and 60! You entered: " + age
                    );
                }

                break;

            } catch (InvalidInputException | InvalidAgeException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }

        
        String designation = "";
        double salary      = 0;

        while (true) {
            System.out.println("\n  Available Roles:");
            System.out.println("  -----------------------");
            System.out.println("  Programmer  -> $20,000");
            System.out.println("  Manager     -> $25,000");
            System.out.println("  Tester      -> $15,000");
            System.out.println("  -----------------------");
            System.out.print("Enter Designation: ");
            designation = scanner.nextLine();

            try {
                if (designation.trim().isEmpty()) {
                    throw new InvalidDesignationException("Designation cannot be empty!");
                }

                
                salary = getDefaultSalary(designation);

                
                System.out.println("Default Salary for " + designation + " : $" + salary);
                break;

            } catch (InvalidDesignationException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }

       
        System.out.println("\n--- Review Details ---");
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Designation : " + designation);
        System.out.println("Salary      : $" + salary);
        System.out.print("Confirm? (y/n): ");

        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y")) {
            names[totalEmployees]        = name;
            ages[totalEmployees]         = age;
            designations[totalEmployees] = designation;
            salaries[totalEmployees]     = salary;
            totalEmployees++;

            System.out.println("\nEmployee created successfully!");

        } else if (confirm.equals("n")) {
            System.out.println("\nEmployee creation cancelled. Going back to main menu...");

        } else {
            System.out.println("\nInvalid input. Going back to main menu...");
        }

    }

  
    static void displayLastEmployee() throws NoEmployeesException {

        System.out.println("\n--- Last Added Employee ---");

        if (totalEmployees == 0) {
            throw new NoEmployeesException("No employees found! Please create one first.");
        }

        
        int lastIndex = totalEmployees - 1;

        System.out.println("Name        : " + names[lastIndex]);
        System.out.println("Age         : " + ages[lastIndex]);
        System.out.println("Designation : " + designations[lastIndex]);
        System.out.println("Salary      : $" + salaries[lastIndex]);
        System.out.println("--------------------");
    }

  
    static void raiseSalary(Scanner scanner) throws NoEmployeesException {

        System.out.println("\n--- Raise Salary ---");

        if (totalEmployees == 0) {
            throw new NoEmployeesException("No employees found! Please create one first.");
        }

       
        System.out.println("Select an Employee:");
        System.out.println("--------------------");
        for (int i = 0; i < totalEmployees; i++) {
            System.out.println((i + 1) + ". " + names[i] +
                               " | " + designations[i] +
                               " | Current Salary: $" + salaries[i]);
        }
        System.out.println("--------------------");

        
        int empNumber = 0;
        while (true) {
            System.out.print("Enter Employee Number: ");
            String empInput = scanner.nextLine();
            try {
                if (!empInput.matches("[0-9]+")) {
                    throw new InvalidInputException("Employee number must be a number!");
                }

                empNumber = Integer.parseInt(empInput);

                if (empNumber < 1 || empNumber > totalEmployees) {
                    throw new InvalidInputException(
                        "Please enter a number between 1 and " + totalEmployees + "!"
                    );
                }

                break;

            } catch (InvalidInputException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }

        int index = empNumber - 1;

        System.out.println("\nEmployee      : " + names[index]);
        System.out.println("Designation   : " + designations[index]);
        System.out.println("Current Salary: $" + salaries[index]);

        
        int percentage = 0;
        while (true) {
            System.out.print("Enter salary raise percentage (1-10): ");
            String percentInput = scanner.nextLine();
            try {
                if (!percentInput.matches("[0-9]+")) {
                    throw new InvalidInputException("Percentage must be a number!");
                }

                percentage = Integer.parseInt(percentInput);

                if (percentage < 1 || percentage > 10) {
                    throw new InvalidPercentageException(
                        "Percentage must be between 1 and 10! You entered: " + percentage
                    );
                }

                break;

            } catch (InvalidInputException | InvalidPercentageException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }

     
        double oldSalary   = salaries[index];
        double raiseAmount = oldSalary * percentage / 100;
        double newSalary   = oldSalary + raiseAmount;

        salaries[index] = newSalary;

        System.out.println("\nSalary updated successfully!");
        System.out.println("--------------------");
        System.out.println("Employee   : " + names[index]);
        System.out.println("Old Salary : $" + oldSalary);
        System.out.println("Raise      : " + percentage + "% = +$" + raiseAmount);
        System.out.println("New Salary : $" + newSalary);
        System.out.println("--------------------");

    }

}
