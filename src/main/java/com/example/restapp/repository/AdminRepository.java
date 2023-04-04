package com.example.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.restapp.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
	Admin findByEmailAndPassword (String email, String password);
}
