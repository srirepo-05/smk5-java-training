package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository - Handles all database operations for the Employee entity.
 *
 * By extending JpaRepository, we get built-in methods like:
 * - save()      : insert or update an employee
 * - findById()  : find employee by ID
 * - findAll()   : get all employees
 * - delete()    : remove an employee
 *
 * We also define a custom query method below.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Finds the most recently added employee by selecting the one with the highest ID.
     * Spring Data JPA automatically generates the SQL query from this method name.
     *
     * SQL equivalent: SELECT * FROM employees ORDER BY id DESC LIMIT 1
     *
     * @return the last inserted Employee, or null if no employees exist
     */
    Employee findTopByOrderByIdDesc();
}
