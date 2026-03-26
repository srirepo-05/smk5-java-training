package com.example.springvalidation.controller;

import com.example.springvalidation.model.Employee;
import com.example.springvalidation.service.MyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private MyService service;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @RequestBody Employee employee) {

        return service.addEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id, @Valid @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

}
