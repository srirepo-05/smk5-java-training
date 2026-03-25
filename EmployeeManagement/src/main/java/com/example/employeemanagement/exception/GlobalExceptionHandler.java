package com.example.employeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler - Catches all custom exceptions thrown anywhere in the app
 * and returns a clean, consistent JSON error response.
 *
 * Example error response:
 * {
 *   "status": 400,
 *   "error": "Bad Request",
 *   "message": "Age must be between 19 and 60"
 * }
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Builds a standard error response map with status code, error label, and message.
     */
    private Map<String, Object> buildErrorResponse(int status, String error, String message) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", status);
        response.put("error", error);
        response.put("message", message);
        return response;
    }

    /**
     * Handles InvalidNameException - returns 400 Bad Request.
     * Triggered when name is empty or has more than 1 space.
     */
    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidNameException(InvalidNameException ex) {
        Map<String, Object> response = buildErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles InvalidAgeException - returns 400 Bad Request.
     * Triggered when age is not between 19 and 60.
     */
    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidAgeException(InvalidAgeException ex) {
        Map<String, Object> response = buildErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles InvalidDesignationException - returns 400 Bad Request.
     * Triggered when designation is not Programmer, Manager, or Tester.
     */
    @ExceptionHandler(InvalidDesignationException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidDesignationException(InvalidDesignationException ex) {
        Map<String, Object> response = buildErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles InvalidPercentageException - returns 400 Bad Request.
     * Triggered when raise percentage is not between 1 and 10.
     */
    @ExceptionHandler(InvalidPercentageException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidPercentageException(InvalidPercentageException ex) {
        Map<String, Object> response = buildErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles NoEmployeesException - returns 404 Not Found.
     * Triggered when no employees exist in the database.
     */
    @ExceptionHandler(NoEmployeesException.class)
    public ResponseEntity<Map<String, Object>> handleNoEmployeesException(NoEmployeesException ex) {
        Map<String, Object> response = buildErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
