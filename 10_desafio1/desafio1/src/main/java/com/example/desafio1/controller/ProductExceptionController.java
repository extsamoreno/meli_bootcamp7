package com.example.desafio1.controller;

import com.example.desafio1.exception.*;
import com.example.desafio1.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(WrongProductIdException.class)
    public ResponseEntity<ErrorDTO> handleException(WrongProductIdException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductInconsistencyException.class)
    public ResponseEntity<ErrorDTO> handleException(ProductInconsistencyException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductPostNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(ProductPostNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PostIdAlreadyInUseException.class)
    public ResponseEntity<ErrorDTO> handleException(PostIdAlreadyInUseException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
