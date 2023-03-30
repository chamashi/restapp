package com.example.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
