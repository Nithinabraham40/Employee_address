package com.tutorial.employleeaddress.customvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.tutorial.employleeaddress.customvalidationimpl.ZipValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

	
	@Target({ElementType.FIELD, ElementType.PARAMETER})
	@Retention(RetentionPolicy.RUNTIME)
	@Constraint(validatedBy = ZipValidation.class)
	public @interface ZipValidator {

		
		String message()default "";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
	}

