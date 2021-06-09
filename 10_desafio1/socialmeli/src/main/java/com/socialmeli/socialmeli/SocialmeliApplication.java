package com.socialmeli.socialmeli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialmeliApplication {
	public static void main(String[] args) {
		SpringApplication.run(SocialmeliApplication.class, args);
	}
}
