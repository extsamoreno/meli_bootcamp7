package com.desafio2.Exception;

import org.springframework.http.HttpStatus;

public class DistrctNotFoundException extends PropertyException{
    public DistrctNotFoundException(String name) {
        super("District with name " + name + " not found.", HttpStatus.NOT_FOUND);
    }
}
