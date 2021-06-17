package com.example.desafio2.controllers;

import com.example.desafio2.dtos.ErrorDTO;
import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyControllerException {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerPropertyNotFoundException(PropertyNotFoundException  e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(NeighborhoodNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNeighborhoodNotFoundException(NeighborhoodNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PropertyAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handlerPropertyAlreadyExistException(PropertyAlreadyExistException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(NeighborhoodAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handlerNeighborhoodAlreadyExistException(NeighborhoodAlreadyExistException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}