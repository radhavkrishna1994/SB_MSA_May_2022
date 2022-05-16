package com.training.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	
	
	public String getName()
	{
		
		return "Sam";
		
	}
	
	public Double getSalary()
	{
		return 125500.25;
	}
}
