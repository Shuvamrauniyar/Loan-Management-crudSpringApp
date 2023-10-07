package com.springboot.HSBCLoanManagement.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "loan_application")
public class LoanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ACCOUNT_NO",nullable = false)
	private String accountNo;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "LOAN_PURPOSE")
	private String loanPurpose;
	
	@Column(name = "DURATION_MONTHS")
	private int durationMonths;
	
	@Column(name = "LOAN_STATUS")
	private String loanStatus;
}



