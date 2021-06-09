package com.meli.spring_challenge.controller;

import com.meli.spring_challenge.exception.PostAlreadyExistException;
import com.meli.spring_challenge.exception.ProductException;
import com.meli.spring_challenge.exception.ProductIDAlreadyExistException;
import com.meli.spring_challenge.service.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(ProductException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PostAlreadyExistException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PostAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductIDAlreadyExistException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(ProductIDAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
