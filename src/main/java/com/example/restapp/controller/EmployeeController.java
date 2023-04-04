package com.example.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapp.entity.Employee;
import com.example.restapp.exception.EmployeeNotFoundException;
import com.example.restapp.repository.EmployeeRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepository;

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return empRepository.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return empRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employee/{id}")
    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return empRepository.findById(id)
                .map(employee -> {
                	employee.setName(newEmployee.getName());
                	employee.setMobile(newEmployee.getMobile());
                	employee.setAddress(newEmployee.getAddress());
                	employee.setEmail(newEmployee.getEmail());
                    return empRepository.save(employee);
                }).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employee/{id}")
    String deleteEmployee(@PathVariable Long id){
        if(!empRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        empRepository.deleteById(id);
        return  "Employee with id "+id+" has been deleted success.";
    }



}