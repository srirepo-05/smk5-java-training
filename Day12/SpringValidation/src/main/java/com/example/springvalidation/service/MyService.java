package com.example.springvalidation.service;


import com.example.springvalidation.model.Employee;
import com.example.springvalidation.repo.EmployeeRepository;
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


    public String addEmployee(Employee employee) {
        repository.save(employee);
        return "Employee added successfully";
    }

    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee deleted successfully";
    }

    public String updateEmployee(int id, Employee employee) {
        if (repository.existsById(id)) {
            employee.setId(id);
            repository.save(employee);
            return "Employee updated successfully";
        } else {
            return "Employee not found";
        }
    }




}
