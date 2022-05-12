package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.training.config.MyConfiguration;
import com.training.interfaces.ConfigurationProcessor;



@SpringBootApplication
public class BookProducerServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookProducerServiceApplication.class, args);
	}
	
	@Autowired
	private ConfigurationProcessor config1;
	
	@Autowired
	private MyConfiguration config;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(config.getMessage());
		System.out.println(config.getStartValue());
		
		System.out.println(config.getEndValue());
		
		config1.process();
	}
	
	

}
