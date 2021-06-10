package com.example.DesafioSpring.controllers;

import com.example.DesafioSpring.dto.ErrorMsgDTO;
import com.example.DesafioSpring.exceptions.ProductNotFoundException;
import com.example.DesafioSpring.exceptions.ProductTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMsgDTO> handleGlobalException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMsgDTO> handleDateExceptions(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ErrorMsgDTO(ex.getMessage().split(" \\(")[0], ex.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProductTakenException.class)
    public ResponseEntity<ErrorMsgDTO> handleGlobalException(ProductTakenException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
