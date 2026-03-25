package com.example.employeemanagement.exception;

/**
 * InvalidPercentageException - Thrown when the salary raise percentage is out of range.
 *
 * This happens when:
 * - Percentage is less than 1 or greater than 10
 */
public class InvalidPercentageException extends RuntimeException {

    public InvalidPercentageException(String message) {
        super(message);
    }
}
