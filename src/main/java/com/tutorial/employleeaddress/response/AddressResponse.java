package com.tutorial.employleeaddress.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressResponse {
	
private Long addressId;
	

	private String streetName;
	
	private String  cityName;
	
	private String stateName;
	
	private Long zipCode;

}
