package com.tutorial.employleeaddress.exceptionhandler;

import java.util.HashMap;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String,String>invalidArjumentException(MethodArgumentNotValidException e){
		
		
		
		HashMap<String,String>errorHandlingMap=new HashMap<>();
		
		List<FieldError>fielderror=e.getBindingResult().getFieldErrors();
		
		for(FieldError error:fielderror) {
			
			errorHandlingMap.put(error.getField(),error.getDefaultMessage());
			
		}
		
		return errorHandlingMap;
		
		
	}
	

}
