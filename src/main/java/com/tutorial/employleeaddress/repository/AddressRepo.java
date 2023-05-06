package com.tutorial.employleeaddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.tutorial.employleeaddress.model.Address;

import jakarta.transaction.Transactional;



public interface AddressRepo extends JpaRepository<Address, Long> {

	
	
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_address set zip_code=:zipcode where address_id=:id",
			nativeQuery = true
			
			)
	
	void updateAdressById( String zipcode, String id);

	
	

}
