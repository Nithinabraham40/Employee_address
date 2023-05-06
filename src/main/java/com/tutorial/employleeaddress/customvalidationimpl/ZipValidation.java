package com.tutorial.employleeaddress.customvalidationimpl;



import com.tutorial.employleeaddress.customvalidation.ZipValidator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ZipValidation implements ConstraintValidator<ZipValidator, Long> {
	
	 @Override
	    public void initialize(ZipValidator constraintAnnotation) {
	    }
	 
	 
	
	 
	 @Override
	 public boolean isValid(Long zipCode, ConstraintValidatorContext context) {
	     
	     
		 String code=zipCode+"";
		 if(code.length()!=5) {
			 return false;
		 }
		 for(int i=0;i<code.length();i++) {
			 
			 char ch=code.charAt(i);
			 
			 if(Character.isLetter(ch)) {
				 return false;
			 }
		 }
		 return true;
		 
	     
	 }

	
	
}
