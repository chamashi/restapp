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

import com.example.restapp.entity.Customer;
import com.example.restapp.exception.CustomerNotFoundException;
import com.example.restapp.repository.CustomerRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customer/{id}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                	customer.setName(newCustomer.getName());
                	customer.setAge(newCustomer.getAge());
                	customer.setAddress(newCustomer.getAddress());
                	customer.setEmail(newCustomer.getEmail());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @DeleteMapping("/customer/{id}")
    String deleteCustomer(@PathVariable Long id){
        if(!customerRepository.existsById(id)){
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
        return  "Customer with id "+id+" has been deleted success.";
    }



}