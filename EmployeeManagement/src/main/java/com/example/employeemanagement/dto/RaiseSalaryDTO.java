package com.example.employeemanagement.dto;

/**
 * RaiseSalaryDTO - Data Transfer Object for the raise salary request.
 *
 * The client sends this in the request body when calling the raise-salary endpoint.
 * Only the percentage field is needed (must be between 1 and 10).
 */
public class RaiseSalaryDTO {

    // The percentage to raise the salary (valid range: 1 to 10)
    private int percentage;

    // -------------------------
    // Default Constructor
    // -------------------------

    public RaiseSalaryDTO() {
    }

    // -------------------------
    // Getter
    // -------------------------

    public int getPercentage() {
        return percentage;
    }

    // -------------------------
    // Setter
    // -------------------------

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
