package com.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication {


	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
		ObjectMapper mapper = JsonMapper.builder()
				.addModule(new GuavaModule())
				.build();
	}

}
