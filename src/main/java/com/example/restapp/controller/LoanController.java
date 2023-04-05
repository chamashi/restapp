package com.example.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.restapp.entity.Loan;
import com.example.restapp.exception.LoanNotFoundException;
import com.example.restapp.repository.LoanRepo;


@RestController
@CrossOrigin("http://localhost:3000")
public class LoanController {

    @Autowired
    private LoanRepo loanrepo;

    @PostMapping("/loan")
    Loan newLoan(@RequestBody Loan newLoan) {
        return loanrepo.save(newLoan);
    }

    @GetMapping("/loans")
    List<Loan> getAllLoans() {
        return loanrepo.findAll();
    }

    @GetMapping("/loan/{id}")
    Loan getLoanById(@PathVariable Long id) {
        return loanrepo.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));
    }
}