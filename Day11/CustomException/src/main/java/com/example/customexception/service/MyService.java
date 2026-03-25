package com.example.customexception.service;

import com.example.customexception.exception.ResourceNotFoundException;
import com.example.customexception.model.Employee;
import com.example.customexception.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
            return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public String addEmployee(Employee employee) {
        repository.save(employee);
        return "Employee added successfully";
    }

    public String updateEmployee(int id, Employee employee) {
        Employee existingEmployee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        repository.save(existingEmployee);
        return "Employee updated successfully";
    }

    public String deleteEmployee(int id) {
        Employee existingEmployee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        repository.delete(existingEmployee);
        return "Employee deleted successfully";
    }

    public String deleteAllEmployees() {
        repository.deleteAll();
        return "All employees deleted successfully";
    }



}
