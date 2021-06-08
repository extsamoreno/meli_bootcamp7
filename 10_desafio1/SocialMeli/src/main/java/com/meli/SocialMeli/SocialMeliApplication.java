package com.meli.SocialMeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialMeliApplication {

	public static void main(String[] args) {
		Config.configUsers();
		Config.configFollows();
		SpringApplication.run(SocialMeliApplication.class, args);
	}

}
