package com.example.desafio2.exception;

import com.example.desafio2.model.Neighborhood;
import org.springframework.http.HttpStatus;

public class NeighborhoodExceptionNotFound extends NeighborhoodException {
    public NeighborhoodExceptionNotFound(String name) {
        super("Neighborhood name: "+ name +" not found", HttpStatus.BAD_REQUEST);
    }
}
