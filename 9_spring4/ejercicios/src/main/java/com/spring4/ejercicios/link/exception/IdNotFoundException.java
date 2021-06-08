package com.spring4.ejercicios.link.exception;

import org.springframework.http.HttpStatus;

public class IdNotFoundException extends LinkException{
    public IdNotFoundException(Integer id) {
        super("The LinkID: " +id+ " is not found in the DataBase.", HttpStatus.NOT_FOUND);
    }
}
