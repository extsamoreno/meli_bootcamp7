package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPassException extends UrlException{
    public InvalidPassException() {
        super("La contraseña es invalida", HttpStatus.BAD_REQUEST);
    }
}
