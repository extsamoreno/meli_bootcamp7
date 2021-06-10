package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidDateFormatException extends ResponseException{
    public InvalidDateFormatException(String strDate) {
        super("El formato de la fecha "+ strDate +" es invalido.", HttpStatus.BAD_REQUEST);
    }
}
