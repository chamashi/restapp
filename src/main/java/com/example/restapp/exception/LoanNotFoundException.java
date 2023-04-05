package com.example.restapp.exception;

public class LoanNotFoundException extends RuntimeException{
    
	public LoanNotFoundException(Long id){
        super("Could not found the loan with id "+ id);
    }
}