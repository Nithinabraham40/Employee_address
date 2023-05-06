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

import com.tutorial.employleeaddress.model.Employee;
import com.tutorial.employleeaddress.response.EmployeeResoponse;
import com.tutorial.employleeaddress.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/add")
	
	public void addEmployee(@Valid @RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);
	}
	
	
	@GetMapping("/all")
	
	public ResponseEntity<List<EmployeeResoponse>> getAllEmployee()
	{
		
	 List<EmployeeResoponse> response=employeeService.getAllEmployee();
		
		return ResponseEntity.status(HttpStatus.OK).body(response);}
	
	@GetMapping("{id}")
	
	public ResponseEntity<EmployeeResoponse>getEmployeeById(@PathVariable int id){
		
		
		EmployeeResoponse response=employeeService.getEmployeeById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
		
	
@PutMapping("/update/address/street/{street}/city/{city}/id/{id}")
	
	public void updateEmployeAddressById(@PathVariable("street")String street,@PathVariable("city") String city,@PathVariable("id") String id) {
	
	
	employeeService.updateEmployeeAddressById(street,city,id);}
	
	


	@DeleteMapping("delete/id/{id}")
	
	public void deleteEmployeeById(@PathVariable String id) {
		
		
		employeeService.deleteEmployeeById(id);
	}
	
	
}
		
		
		
		
	
	


