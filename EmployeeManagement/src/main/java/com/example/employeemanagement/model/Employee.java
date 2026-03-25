package com.example.employeemanagement.model;

import jakarta.persistence.*;

/**
 * Employee Entity - Maps to the "employees" table in the database.
 * Each field corresponds to a column in the table.
 */
@Entity
@Table(name = "employees")
public class Employee {

    // Primary key - auto-incremented by the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Employee's full name
    @Column(nullable = false)
    private String name;

    // Employee's age
    @Column(nullable = false)
    private int age;

    // Employee's job role (Programmer, Manager, Tester)
    @Column(nullable = false)
    private String designation;

    // Employee's salary - auto-assigned based on designation
    @Column(nullable = false)
    private double salary;

    // -------------------------
    // Constructors
    // -------------------------

    /** Default constructor required by JPA */
    public Employee() {
    }

    /** Full constructor for creating an employee with all fields */
    public Employee(String name, int age, String designation, double salary) {
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
