package com.meli.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TuCasitaTasacionesApplication {
    /*@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }*/
    public static void main(String[] args) {
        SpringApplication.run(TuCasitaTasacionesApplication.class, args);
    }

}
