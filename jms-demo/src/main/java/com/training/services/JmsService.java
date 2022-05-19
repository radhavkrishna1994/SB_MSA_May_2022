package com.training.services;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ActiveMQQueue queue;
	
	public String postMessage(String message)
	{
		jmsTemplate.convertAndSend(queue, message);
		
		return message+" published";
	}

}
