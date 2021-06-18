package com.meli.tuCasita.exception;

import com.meli.tuCasita.model.ErrorDTO;
import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends TuCasitaException{
    public DistrictNotFoundException(String name) {
        super("El districto " + name + " no se encuetra registrado.", HttpStatus.NOT_FOUND);
    }
}
