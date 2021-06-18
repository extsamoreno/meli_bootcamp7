package com.desafio2.testing.Exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DistrictNonExistentException extends PropertyException {

    public DistrictNonExistentException(String name) {
        super("El barrio: "+name+" no existe", HttpStatus.BAD_REQUEST);
    }
}
