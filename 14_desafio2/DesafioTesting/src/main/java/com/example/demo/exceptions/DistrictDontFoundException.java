package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictDontFoundException extends ResponseException{
    public DistrictDontFoundException(int distId) {
        super("El barrio con id "+ distId +" no existe", HttpStatus.NOT_FOUND);
    }
}
