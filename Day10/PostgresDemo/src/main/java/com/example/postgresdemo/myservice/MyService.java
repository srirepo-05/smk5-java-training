package com.example.postgresdemo.myservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.employee.Employee;
import com.example.postgresdemo.employeerepo.EmployeeRepo;

@Service
public class MyService {

    @Autowired
    private EmployeeRepo repository;

    // GET ALL
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    // GET BY ID
    public Employee getEmployeeById(int id) {
        Optional<Employee> emp = repository.findById(id);
        return emp.orElse(null);
    }

    // ADD
    public String addEmployee(Employee employee) {
        repository.save(employee);
        return "Employee added successfully";
    }

     public String updateEmployee(int id, Employee updatedEmployee) {
      Optional<Employee> optional = repository.findById(id);

      if (optional.isPresent()) { Employee emp = optional.get();
      emp.setName(updatedEmployee.getName());
      emp.setSalary(updatedEmployee.getSalary()); repository.save(emp); return
      "Employee updated successfully"; }

      return "Employee not found"; }


    public String deleteEmployee(int id) { if
      (repository.existsById(id)) { repository.deleteById(id); return
      "Employee deleted successfully"; } return "Employee not found"; }


     public String deleteAllEmployees() { repository.deleteAll();
     return "All employees deleted"; }

}
