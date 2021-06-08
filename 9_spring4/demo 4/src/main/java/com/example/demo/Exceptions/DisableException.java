package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class DisableException extends UrlException{
    public DisableException() {
        super("El sitio no pudo ser deshabilitdo", HttpStatus.BAD_REQUEST);
    }
}
