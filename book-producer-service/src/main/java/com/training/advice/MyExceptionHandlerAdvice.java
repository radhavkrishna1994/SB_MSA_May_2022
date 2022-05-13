package com.training.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandlerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		Map<String,String> errorMap=new HashMap<>();
		exception.getBindingResult().getFieldErrors()
		.forEach(err->errorMap.put(err.getField(),err.getDefaultMessage()));
		
		return errorMap;
		
	}
	
	
}
