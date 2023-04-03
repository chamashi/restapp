package com.example.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}