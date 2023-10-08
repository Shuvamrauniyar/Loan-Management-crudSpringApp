package com.springboot.HSBCLoanManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.HSBCLoanManagement.model.LoanDetails;

public interface LoanRepository extends JpaRepository<LoanDetails, Long>{

	LoanDetails findLoanById(Long id);

	List<LoanDetails> findLoanByAccountNo(String accountNo);

}
