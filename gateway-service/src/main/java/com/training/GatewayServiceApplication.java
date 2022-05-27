package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder)
	{
		return builder.routes()
		.route(p->p.path("/helloservice1/**")
				.uri("http://localhost:8088"))
		.route(p->p.path("/helloservice2/**")
				.uri("http://localhost:8089")).build();
				
				
	}

}
