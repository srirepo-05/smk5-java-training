package com.example.databasedemo.controller;

import java.util.List;
import java.util.Optional;

import com.example.databasedemo.entity.Employee;
import com.example.databasedemo.repo.MyRepo;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class MyController {

    @Autowired
    private MyRepo repository;


    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }


    @GetMapping("/getAllEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Optional<Employee> emp = repository.findById(id);
        return emp.orElse(null);
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        repository.save(employee);
        return "Employee added successfully";
    }


    // DELETE BY ID
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOpt = repository.findById(id);
        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            repository.save(existingEmployee);
        }
            return "Employee updated successfully";

        }

        @DeleteMapping("/deleteAllEmployees")
        public String deleteAllEmployees() {
            repository.deleteAll();
            return "All employees deleted successfully";
            }



}
