package com.example.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {
	Admin findByEmailAndPassword (String email, String password);
}
