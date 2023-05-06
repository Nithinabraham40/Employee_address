package com.tutorial.employleeaddress.services;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.employleeaddress.model.Employee;
import com.tutorial.employleeaddress.repository.EmployeeRepo;
import com.tutorial.employleeaddress.response.EmployeeResoponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
		
	}

	public List<EmployeeResoponse> getAllEmployee() {
		
		
		List<Employee>allEmployee= employeeRepo.findAll();
		
		ModelMapper modelMap=new ModelMapper();
		
		Type listType = new TypeToken<List<EmployeeResoponse>>() {}.getType();
		
		List<EmployeeResoponse>employeeResponseList=modelMap.map(allEmployee, listType);
		
		return employeeResponseList;
		
		
	}

	public EmployeeResoponse getEmployeeById(int id) {
		
		
	
		Optional<Employee>employee=employeeRepo.findById((long) id);
		
		if(employee.isPresent()) {
			
			ModelMapper modelMap=new ModelMapper();
			EmployeeResoponse employeResponse=modelMap.map(employee.get(), EmployeeResoponse.class);
			
			return  employeResponse;
 

		}
		
		
		return null;
	}

	public void updateEmployeeAddressById(String street, String city, String id) {
		employeeRepo.updateEmployeeAddressById(street,city,id);
		
	}

	public void deleteEmployeeById(String id) {
		
		Long lid=Long.parseLong(id);
		employeeRepo.deleteById(lid);
		
	}

}
