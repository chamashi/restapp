package com.example.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restapp.entity.Loan;

public interface LoanRepo extends JpaRepository<Loan,Long> {
	

}
