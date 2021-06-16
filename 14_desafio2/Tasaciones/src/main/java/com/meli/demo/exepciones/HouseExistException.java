package com.meli.demo.exepciones;

import org.springframework.http.HttpStatus;

public class HouseExistException extends TuCasitaException {

    public HouseExistException(String name) {
        super("la casa con el nombre  " + name+ " ya esta registrada.", HttpStatus.BAD_REQUEST);
    }
}
