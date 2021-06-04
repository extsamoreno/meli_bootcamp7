package com.example.spring4.exceptions;

import org.springframework.http.HttpStatus;

public class UnreachableURLException extends LinkException {
    public UnreachableURLException(Integer id) {
        super("La URL para el id: " + id + " esta dada de baja.", HttpStatus.NOT_FOUND);
    }
}
