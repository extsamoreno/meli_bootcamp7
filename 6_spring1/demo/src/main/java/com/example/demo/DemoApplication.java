package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	//http://localhost:8082/first-api/v1/swagger-ui/index.html#/
	//http://localhost:8082/swagger-ui/index.html#/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
