package com.example.postgresdemo.mycontroller;

import com.example.postgresdemo.employee.Employee;
import com.example.postgresdemo.myservice.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private MyService service;
    // GET ALL
    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }
    // GET BY ID
    @GetMapping("/getAllEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
    // ADD
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

     // UPDATE

      @PutMapping("/updateEmployee/{id}") public String
      updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
      return service.updateEmployee(id, updatedEmployee); }




      @DeleteMapping("/deleteEmployee/{id}") public String
      deleteEmployee(@PathVariable int id) { return service.deleteEmployee(id); }

      @DeleteMapping("/deleteAllEmployee") public String deleteAllEmployee() {
      return service.deleteAllEmployees(); }

}
