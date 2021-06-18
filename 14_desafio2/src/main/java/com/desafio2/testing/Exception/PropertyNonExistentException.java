package com.desafio2.testing.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyNonExistentException extends PropertyException {

    public PropertyNonExistentException(String name) {
        super("La propiedad: "+name+" no existe", HttpStatus.BAD_REQUEST);
    }
}
