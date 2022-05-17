package com.training.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.model.MyUser;
import com.training.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username)  {
		log.info("In userdetails Service...");
		Optional<MyUser> opUser = userRepo.findById(username);
		MyUser myUser=null;
		
		if(opUser.isPresent())
		{
			myUser = opUser.get(); // user2	user123	USER_ROLE,ADMIN_ROLE
			
			log.info("User Object :"+myUser);
			// before java 8
			/*String rolesString[]=myUser.getRole().split(",");
			List<SimpleGrantedAuthority> list = new ArrayList<>();
			
			for(String role:rolesString)
			{
				list.add(new SimpleGrantedAuthority(role));
			}*/
			
			// java 8
			List<SimpleGrantedAuthority> list = Arrays.stream(myUser.getRole().split(","))
												.map(SimpleGrantedAuthority::new)
												.collect(Collectors.toList());

			return new User(username, myUser.getPassword(), list);
		}
		else {		
			
		throw new UsernameNotFoundException("Username mismatch");
		}
	}

}
