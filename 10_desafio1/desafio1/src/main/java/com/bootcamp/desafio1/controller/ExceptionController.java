package com.bootcamp.desafio1.controller;


import com.bootcamp.desafio1.dto.ErrorDTO;
import com.bootcamp.desafio1.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

// USER EXCEPTION
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity(e.getError(), e.getStatus());
    }


// POST EXCEPTION
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlePostNotFoundException(PostNotFoundException e) {
        return new ResponseEntity(e.getError(), e.getStatus());
    }


    @ExceptionHandler(PostAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handlePostAlreadyExistsException(PostAlreadyExistsException e) {
        return new ResponseEntity(e.getError(), e.getStatus());
    }


// PRODUCT EXCEPTION
    @ExceptionHandler(ProductNotFoundException.class)
        public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity(e.getError(), e.getStatus());
    }


    @ExceptionHandler(ProductAlreadyExistsException.class)
        public ResponseEntity<ErrorDTO> handleProductAlreadyExistsException(ProductAlreadyExistsException e) {
        return new ResponseEntity(e.getError(), e.getStatus());
    }

}
