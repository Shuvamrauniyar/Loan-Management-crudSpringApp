package com.springboot.HSBCLoanManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/getLoan/{id}")
	public ResponseEntity<LoanDetails> findLoanById(@PathVariable Long id){
		
		return new ResponseEntity<LoanDetails>(loanDetailService.findLoanById(id),HttpStatus.OK);
	}
	@GetMapping("/getLoanByAccount/{accountNo}")
	public ResponseEntity<List<LoanDetails>> findLoanByAccountNo(@PathVariable String accountNo){
		
		return new ResponseEntity<List<LoanDetails>>(loanDetailService.findLoanByAccountNo(accountNo),HttpStatus.OK);
	}
	@PatchMapping("/updateLoan/{id}")
	public ResponseEntity<LoanDetails> updateLoan(@RequestBody LoanDetails loan,@PathVariable Long id) {
		return new ResponseEntity<LoanDetails>(loanDetailService.updateDetails(loan,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLoanRecord/{id}")
	public ResponseEntity<String> deleteLoanRecord(@PathVariable Long id) {
		//System.out.println(findLoanById(id).getBody());
		
		if(findLoanById(id).getBody() != null)
		{
			loanDetailService.deleteByLoanId(id);
			return ResponseEntity.ok("Deleted record successfully ");
		}
		return new ResponseEntity<String>("Bad request, LoanId not found",HttpStatus.BAD_REQUEST);
	}
	
	
}