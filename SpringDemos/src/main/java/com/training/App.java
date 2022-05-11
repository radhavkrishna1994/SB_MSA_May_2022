package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bean.HelloWorld;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // load the xml file
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	
    	// get an instance of HelloWorld
    	
    	HelloWorld bean = (HelloWorld) ctx.getBean("hello");
    	
    	System.out.println(bean.sayHello());
    	
    }
}
