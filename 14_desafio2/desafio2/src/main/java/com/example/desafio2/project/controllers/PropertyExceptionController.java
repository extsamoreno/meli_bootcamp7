package com.example.desafio2.project.controllers;

import com.example.desafio2.project.exceptions.PropertyAlreadyExistsException;
import com.example.desafio2.project.exceptions.PropertyDistrictNameNotFoundException;
import com.example.desafio2.project.exceptions.PropertyNameNotFoundException;
import com.example.desafio2.project.services.Dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {

    @ExceptionHandler(PropertyNameNotFoundException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PropertyNameNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PropertyAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PropertyAlreadyExistsException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PropertyDistrictNameNotFoundException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PropertyDistrictNameNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

}
