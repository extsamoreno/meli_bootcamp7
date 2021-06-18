package com.desafio2.testing.Exception;

import org.springframework.http.HttpStatus;

public class ExistenPropertyException extends PropertyException {

    public ExistenPropertyException(String name) {
        super("La propiedad: "+name+" ya se encuentra registrada", HttpStatus.BAD_REQUEST);
    }
}
