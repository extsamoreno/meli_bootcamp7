package com.example.desafio1.controllers;

import com.example.desafio1.dtos.ErrorDTO;
import com.example.desafio1.exceptions.PostAlreadyExistsException;
import com.example.desafio1.exceptions.UserIdNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(PostAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostAlreadyExistsException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

}
