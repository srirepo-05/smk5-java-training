package com.example.employeemanagement.exception;

/**
 * InvalidAgeException - Thrown when the employee age fails validation.
 *
 * This happens when:
 * - Age is less than 19 or greater than 60
 */
public class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String message) {
        super(message);
    }
}
