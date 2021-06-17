package com.meli.desafio2;

import com.meli.desafio2.repository.Tables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafio2Application {

	public static void main(String[] args) {
		Tables.fillDB();
		SpringApplication.run(Desafio2Application.class, args);
	}

}
