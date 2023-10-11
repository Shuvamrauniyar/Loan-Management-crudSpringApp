package com.springboot.HSBCLoanManagement.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.HSBCLoanManagement.model.LoanDetails;
import com.springboot.HSBCLoanManagement.repository.LoanRepository;

@Service
public class LoanDetailService {
	
	private LoanRepository loanRepository;
	
	public LoanDetailService(LoanRepository loanRepository) throws SQLException, Exception{
		this.loanRepository = loanRepository;
	}
	
	public LoanDetails createLoanDetails(LoanDetails loanDetails) throws SQLException, Exception{
		return loanRepository.save(loanDetails);
		
	}
	
	public LoanDetails findLoanById(Long id) throws SQLException, Exception{
		
		return loanRepository.findLoanById(id);
	}
	
	public List<LoanDetails> findLoanByAccountNo(String  accountNo) throws SQLException, Exception{
		return loanRepository.findLoanByAccountNo(accountNo);
	}
	
	public LoanDetails updateDetails(LoanDetails loanDetails, Long id) throws SQLException, Exception{
		
		LoanDetails loan =   loanRepository.findLoanById(id);
		
		BigDecimal amount = loanDetails.getAmount();
		int durationMonths = loanDetails.getDurationMonths();
		String loanPurposeString = loanDetails.getLoanPurpose();
		String loanStatus = loanDetails.getLoanStatus();
		
		System.out.println("loan is "+ amount+" "+durationMonths+" "+loanPurposeString+" "+loanStatus);
 		if(amount != null) {
			loan.setAmount(amount);
		}
 		if(durationMonths != 0) {
 			loan.setDurationMonths(durationMonths);
 		}
 		if(loanPurposeString != null) {
 			loan.setLoanPurpose(loanPurposeString);
 		}
 		if(loanStatus != null) {
 			loan.setLoanStatus(loanStatus);
 		}
 		return loanRepository.save(loan);	 
	}

	public void deleteByLoanId(Long id) throws SQLException, Exception{
		loanRepository.deleteById(id);
		return ;
	}
}