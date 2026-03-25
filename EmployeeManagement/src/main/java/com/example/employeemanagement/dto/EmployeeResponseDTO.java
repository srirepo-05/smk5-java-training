package com.example.employeemanagement.dto;

/**
 * EmployeeResponseDTO - Data Transfer Object for returning employee details.
 *
 * This is what the API sends back to the client after creating or fetching an employee.
 */
public class EmployeeResponseDTO {

    // Employee's unique ID from the database
    private Long id;

    // Employee's full name
    private String name;

    // Employee's age
    private int age;

    // Employee's job role
    private String designation;

    // Employee's current salary
    private double salary;

    // -------------------------
    // Default Constructor
    // -------------------------

    public EmployeeResponseDTO() {
    }

    // -------------------------
    // Full Constructor
    // -------------------------

    public EmployeeResponseDTO(Long id, String name, int age, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    // -------------------------
    // Getters
    // -------------------------

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    // -------------------------
    // Setters
    // -------------------------

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
