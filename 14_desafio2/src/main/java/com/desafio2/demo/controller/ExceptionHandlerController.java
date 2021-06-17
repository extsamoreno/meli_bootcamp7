package com.desafio2.demo.controller;

import com.desafio2.demo.dtos.ErrorDTO;
import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerInvalidUserIdException(PropertyNotFoundException  e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(NeighborhoodNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerInvalidUserIdException(NeighborhoodNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
