package com.springboot.HSBCLoanManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.HSBCLoanManagement.model.LoanDetails;
import com.springboot.HSBCLoanManagement.service.LoanDetailService;


@RestController
@RequestMapping("/api")
public class LoanDetailController {

	private LoanDetailService loanDetailService;
	
	public LoanDetailController(LoanDetailService loanDetailService) {
		this.loanDetailService = loanDetailService;
	}
	
	@PostMapping("/applyLoan")
	public ResponseEntity<LoanDetails> createLoanDetails(@RequestBody LoanDetails loan) {
		return new ResponseEntity<LoanDetails>(loanDetailService.createLoanDetails(loan),HttpStatus.CREATED);
	}
}