package com.training.services;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.data.UserData;
import com.training.model.User;

import reactor.core.publisher.Flux;

@Service
public class UserService {
	
	@Autowired
	private UserData userData;
	
	public List<User> getUsers()
	{
		return userData.getUsers();
		
	}
	
	//Reactive
	public Flux<User> getUsersStream()
	{
		return userData.getUsersStream();
		
		
	}
}
