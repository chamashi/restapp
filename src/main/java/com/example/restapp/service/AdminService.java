package com.example.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapp.entity.Admin;
import com.example.restapp.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminrepo;
	  
	  public Admin admin(String email, String password) {
	  Admin user = adminrepo.findByEmailAndPassword(email, password);
	   return user;
	  }

}
