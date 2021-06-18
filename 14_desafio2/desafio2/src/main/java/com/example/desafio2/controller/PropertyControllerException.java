package com.example.desafio2.controller;

import com.example.desafio2.exception.NeighborhoodException;
import com.example.desafio2.exception.PropertyException;
import com.example.desafio2.service.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyControllerException {

    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<ErrorDTO> propertyException(PropertyException e) {
        return new ResponseEntity<ErrorDTO>(e.getError(), e.getStatus());
    }
    @ExceptionHandler(NeighborhoodException.class)
    public ResponseEntity<ErrorDTO> neighborhoodException(NeighborhoodException e) {
        return new ResponseEntity<ErrorDTO>(e.getError(), e.getStatus());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
