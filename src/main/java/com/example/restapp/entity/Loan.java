package com.example.restapp.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long loanid;
	private String customerid;
	private String productname;
	private Long totalloan;
	private Integer installments;
	private Integer paidinstallments;
	private Long loanbalance;
	private Long paidamount;
	private String loandate;
	
	public Long getLoanid() {
		return loanid;
	}
	public void setLoanid(Long loanid) {
		this.loanid = loanid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Long getTotalloan() {
		return totalloan;
	}
	public void setTotalloan(Long totalloan) {
		this.totalloan = totalloan;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	public Integer getPaidinstallments() {
		return paidinstallments;
	}
	public void setPaidinstallments(Integer paidinstallments) {
		this.paidinstallments = paidinstallments;
	}
	public Long getLoanbalance() {
		return loanbalance;
	}
	public void setLoanbalance(Long loanbalance) {
		this.loanbalance = loanbalance;
	}
	public Long getPaidamount() {
		return paidamount;
	}
	public void setPaidamount(Long paidamount) {
		this.paidamount = paidamount;
	}
	public String getLoandate() {
		return loandate;
	}
	public void setLoandate(String loandate) {
		this.loandate = loandate;
	}
	

}
