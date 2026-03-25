package com.example.postgresdemo.employeerepo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.employee.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}


