package com.meli.tuCasita.exception;

import com.meli.tuCasita.model.ErrorDTO;
import org.springframework.http.HttpStatus;

public class HouseNotFoundException extends TuCasitaException {

    public HouseNotFoundException(Long id) {
        super("La casa con Id " + id + " no se encuetra registrado.", HttpStatus.BAD_REQUEST);
    }
}
