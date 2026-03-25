package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeRequestDTO;
import com.example.employeemanagement.dto.EmployeeResponseDTO;
import com.example.employeemanagement.dto.RaiseSalaryDTO;
import com.example.employeemanagement.exception.*;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * EmployeeService - Contains all the business logic for the Employee Management System.
 *
 * This class:
 * - Validates all incoming data (name, age, designation, percentage)
 * - Assigns salary automatically based on designation
 * - Communicates with the repository to read/write from the database
 * - Returns DTOs (not raw entities) back to the controller
 */
@Service
public class EmployeeService {

    // Injecting the repository to access the database
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Creates a new employee and saves them to the database.
     *
     * Steps:
     * 1. Validate name (not empty, max 1 space)
     * 2. Validate age (19 to 60)
     * 3. Validate designation (Programmer, Manager, or Tester)
     * 4. Auto-assign salary based on designation
     * 5. Save employee to database
     * 6. Return saved employee as EmployeeResponseDTO
     *
     * @param requestDTO - contains name, age, designation from the request body
     * @return EmployeeResponseDTO - the saved employee's full details
     */
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {

        // Step 1: Validate Name
        String name = requestDTO.getName();

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be empty!");
        }

        // Count spaces in the name
        int spaceCount = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        if (spaceCount > 1) {
            throw new InvalidNameException(
                "Name can only have 1 space (First + Last name only). You entered " + spaceCount + " spaces."
            );
        }

        // Step 2: Validate Age
        int age = requestDTO.getAge();

        if (age < 19 || age > 60) {
            throw new InvalidAgeException(
                "Age must be between 19 and 60! You entered: " + age
            );
        }

        // Step 3: Validate Designation and assign salary
        String designation = requestDTO.getDesignation();

        if (designation == null || designation.trim().isEmpty()) {
            throw new InvalidDesignationException("Designation cannot be empty!");
        }

        double salary = assignSalaryByDesignation(designation);

        // Step 4: Create and save the Employee entity
        Employee employee = new Employee(name, age, designation, salary);
        Employee savedEmployee = employeeRepository.save(employee);

        // Step 5: Convert saved entity to response DTO and return
        return convertToResponseDTO(savedEmployee);
    }

    /**
     * Retrieves the last employee that was added to the database.
     *
     * Throws NoEmployeesException if the database has no employee records.
     *
     * @return EmployeeResponseDTO - the most recently added employee's details
     */
    public EmployeeResponseDTO getLastEmployee() {

        // Fetch the employee with the highest ID (last inserted)
        Employee lastEmployee = employeeRepository.findTopByOrderByIdDesc();

        // If no employee exists, throw an error
        if (lastEmployee == null) {
            throw new NoEmployeesException("No employees found! Please create one first.");
        }

        // Convert entity to DTO and return
        return convertToResponseDTO(lastEmployee);
    }

    /**
     * Raises the salary of an employee by a given percentage.
     *
     * Steps:
     * 1. Validate percentage (must be between 1 and 10)
     * 2. Find employee by ID (throw error if not found)
     * 3. Calculate new salary: newSalary = oldSalary + (oldSalary * percentage / 100)
     * 4. Save updated salary to database
     * 5. Return a detailed response showing old salary, raise amount, and new salary
     *
     * @param id           - the employee's ID from the URL path
     * @param raiseSalaryDTO - contains the raise percentage from the request body
     * @return Map<String, Object> - a detailed response with salary change info
     */
    public Map<String, Object> raiseSalary(Long id, RaiseSalaryDTO raiseSalaryDTO) {

        // Step 1: Validate percentage
        int percentage = raiseSalaryDTO.getPercentage();

        if (percentage < 1 || percentage > 10) {
            throw new InvalidPercentageException(
                "Raise percentage must be between 1 and 10! You entered: " + percentage
            );
        }

        // Step 2: Find employee by ID
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isEmpty()) {
            throw new NoEmployeesException("Employee with ID " + id + " not found!");
        }

        Employee employee = optionalEmployee.get();

        // Step 3: Calculate new salary
        double oldSalary   = employee.getSalary();
        double raiseAmount = oldSalary * percentage / 100.0;
        double newSalary   = oldSalary + raiseAmount;

        // Step 4: Update and save
        employee.setSalary(newSalary);
        employeeRepository.save(employee);

        // Step 5: Build detailed response
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("id",              employee.getId());
        response.put("name",            employee.getName());
        response.put("designation",     employee.getDesignation());
        response.put("oldSalary",       oldSalary);
        response.put("raisePercentage", percentage);
        response.put("raiseAmount",     raiseAmount);
        response.put("newSalary",       newSalary);

        return response;
    }

    // -------------------------
    // Private Helper Methods
    // -------------------------

    /**
     * Determines the default salary based on the employee's designation.
     *
     * Valid designations and their salaries:
     * - Programmer -> 20000.00
     * - Manager    -> 25000.00
     * - Tester     -> 15000.00
     *
     * Throws InvalidDesignationException if the designation does not match any of the above.
     *
     * @param designation - the job role entered by the user
     * @return double - the assigned salary
     */
    private double assignSalaryByDesignation(String designation) {

        if (designation.equalsIgnoreCase("Programmer")) {
            return 20000.00;
        } else if (designation.equalsIgnoreCase("Manager")) {
            return 25000.00;
        } else if (designation.equalsIgnoreCase("Tester")) {
            return 15000.00;
        } else {
            throw new InvalidDesignationException(
                "\"" + designation + "\" is not a valid designation! Valid roles are: Programmer, Manager, Tester"
            );
        }
    }

    /**
     * Converts an Employee entity to an EmployeeResponseDTO.
     *
     * This keeps the controller and service clean - we never expose
     * the raw entity directly to the API response.
     *
     * @param employee - the Employee entity from the database
     * @return EmployeeResponseDTO - a clean data object for the API response
     */
    private EmployeeResponseDTO convertToResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
            employee.getId(),
            employee.getName(),
            employee.getAge(),
            employee.getDesignation(),
            employee.getSalary()
        );
    }
}
