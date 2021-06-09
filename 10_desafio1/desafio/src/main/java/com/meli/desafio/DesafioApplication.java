package com.meli.desafio;

import com.meli.desafio.utils.DataBase;
import com.meli.desafio.utils.SortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;


@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);

		DataBase db = new DataBase();
		db.loadUsers();
		db.loadPosts();
	}
}
