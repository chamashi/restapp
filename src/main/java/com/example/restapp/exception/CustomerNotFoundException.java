package com.example.restapp.exception;

public class CustomerNotFoundException extends RuntimeException{
    
	public CustomerNotFoundException(Long id){
        super("Could not found the user with id "+ id);
    }
}
