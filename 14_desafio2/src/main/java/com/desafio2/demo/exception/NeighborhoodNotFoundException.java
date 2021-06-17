package com.desafio2.demo.exception;

import org.springframework.http.HttpStatus;

public class NeighborhoodNotFoundException extends PropertyException{
    public NeighborhoodNotFoundException(String neighborhood){
        super("The neighborhood " + neighborhood + "it was not found.", HttpStatus.BAD_REQUEST);
    }
}
