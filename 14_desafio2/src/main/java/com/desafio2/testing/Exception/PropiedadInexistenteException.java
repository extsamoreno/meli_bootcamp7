package com.desafio2.testing.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropiedadInexistenteException extends PropiedadesException{

    public PropiedadInexistenteException(String name) {
        super("La propiedad: "+name+" no existe", HttpStatus.BAD_REQUEST);
    }
}
