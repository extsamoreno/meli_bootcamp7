package com.example.desafio2.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictIdNotValidException extends ResponseException{
    public DistrictIdNotValidException(int id) {
        super("District ID " + id + " is NOT valid.", HttpStatus.BAD_REQUEST);
    }
}
