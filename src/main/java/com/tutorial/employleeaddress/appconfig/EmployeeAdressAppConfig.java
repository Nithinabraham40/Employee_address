package com.tutorial.employleeaddress.appconfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeAdressAppConfig {
	
	
	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}

}
