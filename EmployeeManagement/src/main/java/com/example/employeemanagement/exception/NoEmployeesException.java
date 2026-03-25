package com.example.employeemanagement.exception;

/**
 * NoEmployeesException - Thrown when no employees exist in the database.
 *
 * This happens when:
 * - The client tries to get the last employee but no records exist
 * - The client tries to raise salary for an employee ID that doesn't exist
 */
public class NoEmployeesException extends RuntimeException {

    public NoEmployeesException(String message) {
        super(message);
    }
}
