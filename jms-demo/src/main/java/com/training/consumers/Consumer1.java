package com.training.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {

	@JmsListener(destination = "test-queue")
	public void receiveMessage(String message)
	{
		System.out.println("Message received:"+message);
	}
}
