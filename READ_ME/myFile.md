# Welcome to readme-md-generator &#x1F44B; 
![example workflow](https://img.shields.io/badge/Eclipse-Version%3A%202022--09%20(4.25.0)-orange)
![example workflow](https://img.shields.io/badge/SpringBoot-2.2.1-yellowgreen)
![example workflow](https://img.shields.io/badge/Java-8-yellowgreen)
![example workflow](https://img.shields.io/badge/Postman-v10.13-orange)
![example workflow](https://img.shields.io/badge/Documentation-Yes-green)
![example workflow](https://img.shields.io/badge/Manitained%3F-Yes-green)
 >CLI that generate beautiful **ReadME**.md files

  :house:  <b><span style="color: blue;">Homepage</span></b>
  


 # Prerequisties

 - **Eclipse >=4.55.0**
 - **Postman >=10.13**
 


# Install
```
Maven Install
SpringTool Install
```
 # Framework And Language

 - **Framework :  SpringBoot**
 - **Language :  Java**

 # Dependencies Required

 - **spring-boot-starter-validation**
 - **spring-boot-starter-web**
 - **spring-boot-devtools**
 - **lombok**
 - **spring-boot-starter-test**
 - **spring-boot-starter-data-jpa**
 - **mysql-connector**
 - **modelmapper**

# DataFlow For Employee

<b><span style="color: white;">Controller</span></b>

1. *@PostMapping("/add")*

```
public void addEmployee(@Valid @RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);
	}
```
2. *@GetMapping("/all")*

```
public ResponseEntity<List<EmployeeResoponse>> getAllEmployee()
	{
		
	 List<EmployeeResoponse> response=employeeService.getAllEmployee();
		
		return ResponseEntity.status(HttpStatus.OK).body(response);}
```
3. *@GetMapping("{id}")*

```
public ResponseEntity<EmployeeResoponse>getEmployeeById(@PathVariable int id){
		
		
		EmployeeResoponse response=employeeService.getEmployeeById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
```
4. *@PutMapping("/update/address/street/{street}/city/{city}/id/{id}")*

```
public void updateEmployeAddressById(@PathVariable("street")String street,@PathVariable("city") String city,@PathVariable("id") String id) {
	
	
	employeeService.updateEmployeeAddressById(street,city,id);}
	
	
```
5. *@DeleteMapping("delete/id/{id}")*

```
public void deleteEmployeeById(@PathVariable String id) {
		
		
		employeeService.deleteEmployeeById(id);
	}
```



<b><span style="color: white;">Services</span></b>

1. *addEmployee*

```
public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
		
	}
```

2. *getAllEmployee()*

```
public List<EmployeeResoponse> getAllEmployee() {
		
		
		List<Employee>allEmployee= employeeRepo.findAll();
		
		ModelMapper modelMap=new ModelMapper();
		
		Type listType = new TypeToken<List<EmployeeResoponse>>() {}.getType();
		
		List<EmployeeResoponse>employeeResponseList=modelMap.map(allEmployee, listType);
		
		return employeeResponseList;
		
		
	}
```
3. *getEmployeeById*

```
public EmployeeResoponse getEmployeeById(int id) {
		
		
	
		Optional<Employee>employee=employeeRepo.findById((long) id);
		
		if(employee.isPresent()) {
			
			ModelMapper modelMap=new ModelMapper();
			EmployeeResoponse employeResponse=modelMap.map(employee.get(), EmployeeResoponse.class);
			
			return  employeResponse;
 

		}
		
		
		return null;
	}
```
4. *updateEmployeeAddressById*

```
public void updateEmployeeAddressById(String street, String city, String id) {
		employeeRepo.updateEmployeeAddressById(street,city,id);
		
	}
```
5. *deleteEmployeeById*

```
public void deleteEmployeeById(String id) {
		
		Long lid=Long.parseLong(id);
		employeeRepo.deleteById(lid);
		
	}
```


<b><span style="color: white;">Repository</span></b>

```

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
```

# DataFlow For Address

<b><span style="color: white;">Controller</span></b>

1. *@PostMapping("/add")*

```

	
	public void addAddress(@Valid @RequestBody Address address) {
		
		addressServices.addAddress(address);
		
	}
```
2. *@GetMapping("/all")*

```
	public ResponseEntity<List<AddressResponse>>getAllAddress()
	{
		
		
		List<AddressResponse>allAddress=addressServices.getAllAddress();
		
		
		return ResponseEntity.status(HttpStatus.OK).body(allAddress);
		
		
	}
```
3. *@GetMapping("id/{id}")*

```
public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id) {
		
		
		AddressResponse addressResponse= addressServices.getAddressById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
```
4. *@PutMapping("update/zipcode/{zipcode}/id/{id}")*

```
public void updateAdressById( @PathVariable("zipcode")String zipCode,@PathVariable ("id")String id
				) {
		
		addressServices.updateAdressById(zipCode,id);
	
	}
	
```
5. *@DeleteMapping("delete/{id}")*

```
public void deleteAddressById(@PathVariable String id) {
		
		addressServices.deleteAddressById(id);
	}
	
```


<b><span style="color: white;">Services</span></b>

1. *addAddress*

```
public void addAddress(Address address) {
		
		
		addressRepo.save(address);	
	}
```

2. *getAllAddress()*

```
public List<AddressResponse> getAllAddress() {
	
		List<Address>allAddress=addressRepo.findAll();
		
		ModelMapper modelMap=new ModelMapper();
		
		Type listType = new TypeToken<List<AddressResponse>>() {}.getType();
	
		
		List<AddressResponse>responseList=	modelMap.map(allAddress, listType);
		
		return responseList;
	}
```
3. *getAddressById*

```
public AddressResponse getAddressById(Long id) {
		
		
		Optional<Address>address=addressRepo.findById(id);
		
		if(address.isPresent()) {
			ModelMapper modelMap=new ModelMapper();
			AddressResponse addressResonse=modelMap.map(address.get(), AddressResponse.class);
			
			return addressResonse;
			
		}
		
		return null;
	}
```
4. *updateAdressById*

```
public void updateAdressById( String zipcode, String id) {
	
		addressRepo.updateAdressById(zipcode,id);
	}
```
5. *deleteAddressById*

```

	public void deleteAddressById(String id) {
		
		Long lid=Long.parseLong(id);
		
		addressRepo.deleteById(lid);
		
	}
```

<b><span style="color: white;">Repository</span></b>

```
	
	public interface AddressRepo extends JpaRepository<Address, Long> {

	

	@Modifying
	@Transactional
	@Query(
			value = "update tbl_address set zip_code=:zipcode where address_id=:id",
			nativeQuery = true
			
			)
	
	void updateAdressById( String zipcode, String id);	
	

}
```




	
	


  


	







	



# Database Used

<details>
<summary><b><span style="color: white;">Clickme</span></b> &#x1F4F2; </summary>

*Mysql*



</details>

 # Database Design For Employee Model

 - **Primary Key :  employee_id**
 - **Generationstrategy:  identity**
  - **Mapping with Address:one to one uni directional**
  - **foreigh key: fk_address_addressid**
  
 - **Columns Used:  employee_id,first_name , last_name, fk_address_addressid**

 # Database Design For Address Model

 - **Primary Key :  address_id**
 - **Generationstrategy:  Sequence**
 - **Columns Used:  address_id,city_name , street_name,state_name,zip_code**




# Summary

 Spring Project based on Employee address one to one relationship.
The model will have the following attribute
**employeeId**,
**lastName**,
**firstName**,
**addressId**,
**streetName**,
**cityName**,
**stateName**,
**zipCode**
. Along with these proper validations are also provided.Used CRUD operation,Custom finders and Custom Query
to do necessary operations.






# :handshake:  Contributing
  Contributions,issues and features request are welcome! 
  

  #


  This *README* was generated with &#x2764;&#xFE0F; by <b><span style="color: blue;">readme-md-generator</span></b> 










   
  
  

