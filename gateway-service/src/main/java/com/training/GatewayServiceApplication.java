package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
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
				.filters(f->f.addRequestHeader("Authorization", "Bearer hsgdsajarzxxxxaaa")
				.addResponseHeader("my-response-header", "This is a sample response header"))
				
				//.uri("http://localhost:8088"))
		        .uri("lb://service1"))
		.route(p->p.path("/helloservice2/**")
				//.uri("http://localhost:8089"))
				.uri("lb://service2"))
				.build();
				
				
	}

}
