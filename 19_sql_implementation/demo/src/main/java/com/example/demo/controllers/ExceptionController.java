package com.example.demo.controllers;

import com.example.demo.exceptions.DentistNotFoundException;
import com.example.demo.services.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DentistNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(DentistNotFoundException e) {
        return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
    }

}
