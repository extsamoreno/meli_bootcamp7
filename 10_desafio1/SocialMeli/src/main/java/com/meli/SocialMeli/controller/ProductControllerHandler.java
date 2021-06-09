package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<String> productExceptionHandler(ProductException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
