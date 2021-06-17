package com.example.desafio2;

import com.example.desafio2.project.utils.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafio2Application {

    public static void main(String[] args) {
        SpringApplication.run(Desafio2Application.class, args);

        Database db = new Database();
        db.loadPropertiesDataBase();
        db.loadDistrictsDataBase();
    }

}
