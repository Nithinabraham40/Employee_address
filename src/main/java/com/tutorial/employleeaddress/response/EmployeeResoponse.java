package com.tutorial.employleeaddress.response;

import com.tutorial.employleeaddress.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeResoponse {
	
	
	private Long employeeId;
	
	private String firstName;
	

	private String lastName;
	
	
	private Address address;

}
