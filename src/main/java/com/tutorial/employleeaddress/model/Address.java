package com.tutorial.employleeaddress.model;

import com.tutorial.employleeaddress.customvalidation.ZipValidator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_address")
public class Address {
	

	@Id
	@SequenceGenerator(
			name = "address_sequence",
			sequenceName = "address_sequence",
			allocationSize = 1,
			initialValue = 1000
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "address_sequence")
	private Long addressId;
	
	@NotBlank(message = "This field cannot be empty")
	@Size(min = 2,max = 40,message = "Maintain a size Between 2 to 40")
	private String streetName;
	@NotBlank(message = "This field cannot be empty")
	private String  cityName;
	@NotBlank(message = "This field cannot be empty")
	private String stateName;
	@ZipValidator(message="Give valid zip of length five all in digit ")
	private Long zipCode;
	

}
