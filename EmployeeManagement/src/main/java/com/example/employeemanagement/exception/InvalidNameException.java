package com.example.employeemanagement.exception;

/**
 * InvalidNameException - Thrown when the employee name fails validation.
 *
 * This happens when:
 * - Name is empty or blank
 * - Name contains more than 1 space (only First + Last name allowed)
 */
public class InvalidNameException extends RuntimeException {

    public InvalidNameException(String message) {
        super(message);
    }
}
