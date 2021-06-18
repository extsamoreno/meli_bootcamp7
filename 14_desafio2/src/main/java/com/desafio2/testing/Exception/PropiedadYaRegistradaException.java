package com.desafio2.testing.Exception;

import org.springframework.http.HttpStatus;

public class PropiedadYaRegistradaException extends PropiedadesException{

    public PropiedadYaRegistradaException(String name) {
        super("La propiedad: "+name+" ya se encuentra registrada", HttpStatus.BAD_REQUEST);
    }
}
