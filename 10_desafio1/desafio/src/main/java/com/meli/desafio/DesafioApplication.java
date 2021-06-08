package com.meli.desafio;

import com.meli.desafio.models.Post;
import com.meli.desafio.utils.DataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);

		DataBase db = new DataBase();
		db.loadUsers();
		db.loadPosts();
	}
}
