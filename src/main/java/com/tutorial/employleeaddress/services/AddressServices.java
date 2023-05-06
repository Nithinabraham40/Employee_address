package com.tutorial.employleeaddress.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.tutorial.employleeaddress.customvalidation.ZipValidator;
import com.tutorial.employleeaddress.model.Address;
import com.tutorial.employleeaddress.repository.AddressRepo;
import com.tutorial.employleeaddress.response.AddressResponse;
import com.tutorial.employleeaddress.response.EmployeeResoponse;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Service
public class AddressServices {

	
	@Autowired
	private AddressRepo addressRepo;

	public void addAddress(Address address) {
		
		
		addressRepo.save(address);	
	}

	public List<AddressResponse> getAllAddress() {
	
		List<Address>allAddress=addressRepo.findAll();
		
		ModelMapper modelMap=new ModelMapper();
		
		Type listType = new TypeToken<List<AddressResponse>>() {}.getType();
	
		
		List<AddressResponse>responseList=	modelMap.map(allAddress, listType);
		
		return responseList;
	}

	public AddressResponse getAddressById(Long id) {
		
		
		Optional<Address>address=addressRepo.findById(id);
		
		if(address.isPresent()) {
			ModelMapper modelMap=new ModelMapper();
			AddressResponse addressResonse=modelMap.map(address.get(), AddressResponse.class);
			
			return addressResonse;
			
		}
		
		return null;
	}

	public void updateAdressById( String zipcode, String id) {
	
		addressRepo.updateAdressById(zipcode,id);
	}

	
	@Modifying
	@Transactional
	public void deleteAddressById(String id) {
		
		Long lid=Long.parseLong(id);
		
		
		addressRepo.deleteById(lid);
		
	}



	
	
	
	
	
}
