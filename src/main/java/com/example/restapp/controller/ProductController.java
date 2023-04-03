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

import com.example.restapp.entity.Product;
import com.example.restapp.exception.ProductNotFoundException;
import com.example.restapp.repository.ProductRepository;


@RestController
@CrossOrigin("http://localhost:3000")

public class ProductController {
	
	@Autowired
    private ProductRepository productRepository;

    @PostMapping("/product")
    Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @GetMapping("/products")
    List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/product/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                	product.setName(newProduct.getName());
                	product.setBrand(newProduct.getBrand());
                	product.setCountry(newProduct.getCountry());
                	product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @DeleteMapping("/product/{id}")
    String deleteProduct(@PathVariable Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        return  "Product with id "+id+" has been deleted success.";
    }




}
