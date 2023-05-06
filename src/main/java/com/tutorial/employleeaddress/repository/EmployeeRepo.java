package com.tutorial.employleeaddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tutorial.employleeaddress.model.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	
	
	@Modifying
	@Transactional
	@Query(
			value="UPDATE tbl_address a \r\n"
					+ "INNER JOIN tbl_employee e \r\n"
					+ "ON a.address_id = e.fk_address_addressid \r\n"
					+ "SET a.street_name = :street, a.city_name = :city \r\n"
					+ "WHERE e.employee_id = :id",
					nativeQuery = true
			)
	public void updateEmployeeAddressById(String street, String city, String id);
	


}
