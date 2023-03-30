package com.example.restapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restapp.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	public List<Customers>listAll() {		
		return repo.findAll();
	}
	
	public void save(Customer customer) {
		repo.save(customer);
	}
	
	public Customers get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}

