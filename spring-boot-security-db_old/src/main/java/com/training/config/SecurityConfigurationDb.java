package com.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.training.services.MyUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfigurationDb extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new PasswordEncoder()
				{
					@Override
					public String encode(CharSequence rawPassword) {
						log.info("Encode method");
						return rawPassword.toString();
					}

					@Override
					public boolean matches(CharSequence rawPassword, String encodedPassword) {
						log.info("Matches method");
						return rawPassword.equals(encodedPassword);
					}
			
				};
	}
	
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
				log.info("In Authentication");
	 
				auth
				.userDetailsService(myUserDetailsService)
				.passwordEncoder(getPasswordEncoder());
				
		
	}
	
	//Authorization
	
	public void configure(HttpSecurity http) throws Exception
	{
		log.info("In Authorization");
		http
		//.csrf().disable()
		//.headers().frameOptions().disable()
		//.and()
		.authorizeRequests()
		.antMatchers("/user/**")
		.hasRole("USER")
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.and()
		.formLogin();
		
	}
	

}
