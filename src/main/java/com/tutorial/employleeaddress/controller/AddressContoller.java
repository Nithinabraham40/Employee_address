package com.tutorial.employleeaddress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tutorial.employleeaddress.model.Address;
import com.tutorial.employleeaddress.response.AddressResponse;
import com.tutorial.employleeaddress.services.AddressServices;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/address")

public class AddressContoller {
	
	@Autowired
	private AddressServices addressServices;
	
	
	@PostMapping("/add")
	
	public void addAddress(@Valid @RequestBody Address address) {
		
		addressServices.addAddress(address);
		
	}
	
	@GetMapping("/all")
	
	public ResponseEntity<List<AddressResponse>>getAllAddress()
	{
		
		
		List<AddressResponse>allAddress=addressServices.getAllAddress();
		
		
		return ResponseEntity.status(HttpStatus.OK).body(allAddress);
		
		
	}
	
	@GetMapping("id/{id}")
	
	public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id) {
		
		
		AddressResponse addressResponse= addressServices.getAddressById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
	
	@PutMapping("update/zipcode/{zipcode}/id/{id}")
	
	public void updateAdressById( @PathVariable("zipcode")String zipCode,@PathVariable ("id")String id
				) {
		
		
		
		addressServices.updateAdressById(zipCode,id);
		
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteAddressById(@PathVariable String id) {
		
		addressServices.deleteAddressById(id);
	}

	
	
	
	

}
