package com.example.springclase4.project.exception;

import org.springframework.http.HttpStatus;

public class UrlNotFoundException extends UrlException{
    public UrlNotFoundException(String linkId){
        super("El id: " + linkId + " no existe en la base de datos.", HttpStatus.NOT_FOUND);
    }
}
