package com.example.databasedemo2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.databasedemo2.employee.Employee;
import com.example.databasedemo2.repo.EmployeeRepo;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepo repo;
    // INSERT (Use JPA - SAFE)
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee emp) {
        repo.save(emp);   // IMPORTANT
        return "Employee Added";
    }
    //  GET ALL (Native)
    @GetMapping("/getAllEmployee")
    public List<Employee> getAll() {
        return repo.getAllEmployees();
    }
    // GET BY ID
    @GetMapping("/getEmployee/{id}")
    public Employee getById(@PathVariable int id) {
        return repo.getEmployeeById(id);
    }
    //  UPDATE
    @PutMapping("/updateEmployee/{id}")
    public String update(@PathVariable int id, @RequestBody Employee emp) {
        int rows = repo.updateEmployee(emp.getName(), emp.getSalary(), id);

        if (rows > 0)
            return "Updated Successfully";
        else
            return "Employee Not Found";
    }
    //  DELETE
    @DeleteMapping("/deleteEmployee/{id}")
    public String delete(@PathVariable int id) {
        int rows = repo.deleteEmployee(id);
        if (rows > 0)
            return "Deleted Successfully";
        else
            return "Employee Not Found";
    }
}
