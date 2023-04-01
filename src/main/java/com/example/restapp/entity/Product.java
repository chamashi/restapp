package com.example.restapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "product_name")
	private String product_name;

	@Column(name = "brand")
	private String brand;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "price")
	private String price;
	
	public Product() {
		
	}

	public Product(String product_name, String brand, String country, String price) {
		super();
		this.product_name = product_name;
		this.brand = brand;
		this.country = country;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}