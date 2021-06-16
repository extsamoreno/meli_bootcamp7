package com.meli.demo.exepciones;

import org.springframework.http.HttpStatus;

public class PriceIncorrectException extends TuCasitaException{

    public PriceIncorrectException(String name, Double price) {
        super("El precio del barrio  " + name+ " no esta registrado en la base de datos por ."+price, HttpStatus.NOT_FOUND);
    }
}
