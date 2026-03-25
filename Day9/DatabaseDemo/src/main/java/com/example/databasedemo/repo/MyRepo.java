package com.example.databasedemo.repo;

import com.example.databasedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository<Employee, Integer> {

}
