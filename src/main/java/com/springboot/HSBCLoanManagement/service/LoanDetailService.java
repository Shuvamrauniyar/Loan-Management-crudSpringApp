package com.springboot.HSBCLoanManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.HSBCLoanManagement.model.LoanDetails;
import com.springboot.HSBCLoanManagement.repository.LoanRepository;

@Service
public class LoanDetailService {
	
	private LoanRepository loanRepository;
	
	public LoanDetailService(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}
	
	public LoanDetails createLoanDetails(LoanDetails loanDetails) {
		return loanRepository.save(loanDetails);
		
	}
	
	public LoanDetails findLoanById(Long id) {
		
		return loanRepository.findLoanById(id);
	}
	
	public List<LoanDetails> findLoanByAccountNo(String  accountNo) {
		return loanRepository.findLoanByAccountNo(accountNo);
	}
}