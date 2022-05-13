package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.training.config.MyConfiguration;
import com.training.interfaces.ConfigurationProcessor;
import com.training.model.Book;
import com.training.repo.BookRepo;



@SpringBootApplication
public class BookProducerServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookProducerServiceApplication.class, args);
	}
	
	/*
	 * @Autowired private ConfigurationProcessor config1;
	 * 
	 * @Autowired private MyConfiguration config;
	 */

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * System.out.println(config.getMessage());
		 * System.out.println(config.getStartValue());
		 * 
		 * System.out.println(config.getEndValue());
		 * 
		 * config1.process();
		 */
	}
	@Autowired
	private BookRepo bookRepo;
	
	/*
	 * @PostConstruct public void saveBooks() { bookRepo.save(new
	 * Book(1234l,"C",150.25,100l)); bookRepo.save(new
	 * Book(4322l,"CPlus",250.25,100l)); bookRepo.save(new
	 * Book(3456l,"Python",175.25,100l)); bookRepo.save(new Book(5678l, "CSharp",
	 * 225.25, 100l)); }
	 */
	
	

}
