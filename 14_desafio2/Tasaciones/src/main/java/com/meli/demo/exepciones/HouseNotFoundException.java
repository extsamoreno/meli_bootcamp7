package com.meli.demo.exepciones;

import org.springframework.http.HttpStatus;

public class HouseNotFoundException extends TuCasitaException {

    public HouseNotFoundException(String name) {
        super("El casa con el nombre  " + name+ " no se encuetra registrada.", HttpStatus.NOT_FOUND);
    }
}
