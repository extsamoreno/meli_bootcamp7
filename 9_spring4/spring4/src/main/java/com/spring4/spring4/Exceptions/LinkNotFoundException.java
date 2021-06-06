package com.spring4.spring4.Exceptions;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends ObjectException{
    public LinkNotFoundException(Integer id) {
        super("No se encontró un link para el Id: " + id.toString(), HttpStatus.NOT_FOUND);
    }
}
