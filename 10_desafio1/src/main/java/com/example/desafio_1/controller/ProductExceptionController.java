package com.example.desafio_1.controller;

import com.example.desafio_1.exception.ProductException;
import com.example.desafio_1.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorDTO> handleUserException(ProductException exception) {
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }
}
