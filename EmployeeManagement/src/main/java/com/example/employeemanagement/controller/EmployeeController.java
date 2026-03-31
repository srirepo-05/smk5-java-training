package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeRequestDTO;
import com.example.employeemanagement.dto.EmployeeResponseDTO;
import com.example.employeemanagement.dto.RaiseSalaryDTO;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * EmployeeController - Handles all incoming HTTP requests for the Employee API.
 * Base URL: /api/employees
 * Available Endpoints:
 * - POST   /api/employees/create            -> Create a new employee
 * - GET    /api/employees/last              -> Get the last created employee
 * - PUT    /api/employees/raise-salary/{id} -> Raise an employee's salary
 * This controller delegates all business logic to EmployeeService.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // Injecting the service layer
    @Autowired
    private EmployeeService employeeService;

    /**
     * GET /api/employees/all
     *
     * Returns all employees from the database.
     * This endpoint is protected — requires authentication (admin / admin123).
     *
     * Success Response (200 OK) - list of all employees:
     * [
     *   { "id": 1, "name": "John Doe", "age": 25, "designation": "Programmer", "salary": 20000.0 },
     *   { "id": 2, "name": "Jane Smith", "age": 30, "designation": "Manager",    "salary": 25000.0 }
     * ]
     *
     * Error Response (404 Not Found) - when no employees exist:
     * {
     *   "status": 404,
     *   "error": "Not Found",
     *   "message": "No employees found! Please create one first."
     * }
     *
     * @return ResponseEntity containing a list of all employees
     */
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<EmployeeResponseDTO> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * POST /api/employees/create
     *
     * Creates a new employee with the provided name, age, and designation.
     * Salary is NOT provided by the client — it is automatically assigned
     * based on the designation.
     *
     * Request Body (JSON):
     * {
     *   "name": "John Doe",
     *   "age": 25,
     *   "designation": "Programmer"
     * }
     *
     * Success Response (201 Created):
     * {
     *   "id": 1,
     *   "name": "John Doe",
     *   "age": 25,
     *   "designation": "Programmer",
     *   "salary": 20000.0
     * }
     *
     * @param requestDTO - the employee data from the request body
     * @return ResponseEntity containing the created employee details
     */
    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeRequestDTO requestDTO) {
        EmployeeResponseDTO createdEmployee = employeeService.createEmployee(requestDTO);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    /**
     * GET /api/employees/last
     *
     * Returns the most recently created employee from the database.
     *
     * Success Response (200 OK):
     * {
     *   "id": 3,
     *   "name": "Jane Smith",
     *   "age": 30,
     *   "designation": "Manager",
     *   "salary": 25000.0
     * }
     *
     * Error Response (404 Not Found) - when no employees exist:
     * {
     *   "status": 404,
     *   "error": "Not Found",
     *   "message": "No employees found! Please create one first."
     * }
     *
     * @return ResponseEntity containing the last employee's details
     */
    @GetMapping("/last")
    public ResponseEntity<EmployeeResponseDTO> getLastEmployee() {
        EmployeeResponseDTO lastEmployee = employeeService.getLastEmployee();
        return new ResponseEntity<>(lastEmployee, HttpStatus.OK);
    }

    /**
     * PUT /api/employees/raise-salary/{id}
     *
     * Raises the salary of the employee with the given ID by a specified percentage.
     *
     * URL Parameter:
     * - id: the unique ID of the employee (e.g., /api/employees/raise-salary/1)
     *
     * Request Body (JSON):
     * {
     *   "percentage": 5
     * }
     *
     * Success Response (200 OK):
     * {
     *   "id": 1,
     *   "name": "John Doe",
     *   "designation": "Programmer",
     *   "oldSalary": 20000.0,
     *   "raisePercentage": 5,
     *   "raiseAmount": 1000.0,
     *   "newSalary": 21000.0
     * }
     *
     * Error Response (400 Bad Request) - when percentage is out of range:
     * {
     *   "status": 400,
     *   "error": "Bad Request",
     *   "message": "Raise percentage must be between 1 and 10!"
     * }
     *
     * @param id           - the employee ID from the URL path variable
     * @param raiseSalaryDTO - contains the raise percentage from the request body
     * @return ResponseEntity containing salary raise details
     */
    @PutMapping("/raise-salary/{id}")
    public ResponseEntity<Map<String, Object>> raiseSalary(
            @PathVariable Long id,
            @RequestBody RaiseSalaryDTO raiseSalaryDTO) {

        Map<String, Object> response = employeeService.raiseSalary(id, raiseSalaryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
