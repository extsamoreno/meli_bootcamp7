package com.meli.demo.exepciones;

import org.springframework.http.HttpStatus;

public class NeighborhoodNotFounException extends TuCasitaException{

    public NeighborhoodNotFounException(String name) {
        super("El barrio con el nombre  " + name+ " no se encuetra registrada.", HttpStatus.NOT_FOUND);
    }
}
