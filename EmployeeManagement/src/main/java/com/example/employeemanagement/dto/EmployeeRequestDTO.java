package com.example.employeemanagement.dto;

/**
 * EmployeeRequestDTO - Data Transfer Object for creating a new employee.
 *
 * This is what the client sends in the request body (JSON).
 * Note: Salary is NOT included here - it is auto-assigned based on designation.
 */
public class EmployeeRequestDTO {

    // Employee's full name (First + Last name only)
    private String name;

    // Employee's age (must be between 19 and 60)
    private int age;

    // Employee's job role: Programmer, Manager, or Tester
    private String designation;

    // -------------------------
    // Default Constructor
    // -------------------------

    public EmployeeRequestDTO() {
    }

    // -------------------------
    // Getters
    // -------------------------

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }

    // -------------------------
    // Setters
    // -------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
