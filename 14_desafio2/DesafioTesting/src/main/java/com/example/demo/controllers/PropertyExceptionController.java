package com.example.demo.controllers;

import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.services.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {
    @ExceptionHandler(PropertyDontFoundException.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(PropertyDontFoundException e) {
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
