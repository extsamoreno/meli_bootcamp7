package com.tucasita.tasaciones;

import com.tucasita.tasaciones.project.utils.Database;
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
