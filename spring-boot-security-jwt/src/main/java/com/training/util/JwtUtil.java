package com.training.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private String secret = "jwt123";
	
	public String generateToken(String username)
	{
		return Jwts
		.builder()
		.setSubject(username)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60 * 1))
		.signWith(SignatureAlgorithm.HS256, secret)
		.compact();
	}

	public static void main(String[] args) {
		System.out.println(new JwtUtil().generateToken("user1"));
	}
}
