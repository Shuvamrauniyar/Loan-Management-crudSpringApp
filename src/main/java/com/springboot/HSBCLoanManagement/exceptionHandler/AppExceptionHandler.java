package com.springboot.HSBCLoanManagement.exceptionHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLException.class)
	public Map<String, String>handleSQLException(SQLException ex){
		Map<String, String>errorMap= new HashMap<>();
		errorMap.put("Error message", ex.getMessage());
		return errorMap;
	}
	
	
	@ExceptionHandler(Exception.class)
	public Map<String, String>handleException(Exception ex){
		Map<String, String>errorMap= new HashMap<>();
		errorMap.put("Error message", ex.getMessage());
		return errorMap;
	}
}
