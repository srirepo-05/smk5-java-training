package com.example.employeemanagement.exception;

/**
 * InvalidDesignationException - Thrown when the employee designation is not valid.
 *
 * This happens when:
 * - Designation is empty or blank
 * - Designation is not one of: Programmer, Manager, Tester
 */
public class InvalidDesignationException extends RuntimeException {

    public InvalidDesignationException(String message) {
        super(message);
    }
}
