package com.example.demo.project.controller;

import com.example.demo.project.exception.ProductException;
import com.example.demo.project.exception.ProductIdNotFoundException;
import com.example.demo.project.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductIdNotFoundException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
