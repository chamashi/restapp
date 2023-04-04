package com.example.restapp.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapp.entity.Admin;
import com.example.restapp.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {

	@Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> admin(@RequestBody Admin admin) {

        Admin oauthUser = adminService.admin(admin.getEmail(), admin.getPassword());

        if (Objects.nonNull(oauthUser)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {

        // Perform logout operation here
        return ResponseEntity.ok("Logout successful");
    }
}
