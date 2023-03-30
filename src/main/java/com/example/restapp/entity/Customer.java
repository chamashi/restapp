package com.example.restapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String fullName;
    private double loanBalance;
    private double usedAmount;
    private String installmentPlan;
    private String password;
    private String email;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(double loanBalance) {
		this.loanBalance = loanBalance;
	}

	public double getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(double usedAmount) {
		this.usedAmount = usedAmount;
	}

	public String getInstallmentPlan() {
		return installmentPlan;
	}

	public void setInstallmentPlan(String installmentPlan) {
		this.installmentPlan = installmentPlan;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(Long id, String fullName, double loanBalance, double usedAmount, String installmentPlan,
			String password, String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.loanBalance = loanBalance;
		this.usedAmount = usedAmount;
		this.installmentPlan = installmentPlan;
		this.password = password;
		this.email = email;
	}

	public Customer() {
		super();
		
	}    

}