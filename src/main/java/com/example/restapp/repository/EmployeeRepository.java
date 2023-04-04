package com.example.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}