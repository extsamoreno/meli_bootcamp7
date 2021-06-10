package com.example.Challenge.controller;
import com.example.Challenge.dto.ErrorDTO;
import com.example.Challenge.exception.ProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}