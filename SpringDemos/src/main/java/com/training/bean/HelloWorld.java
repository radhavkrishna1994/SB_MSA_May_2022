package com.training.bean;

public class HelloWorld {
	
	private String message;
	
	public HelloWorld(String message)
	{
		this.message=message;
	}
	
	public HelloWorld() { }
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String sayHello()
	{
		return message;
	}

}
