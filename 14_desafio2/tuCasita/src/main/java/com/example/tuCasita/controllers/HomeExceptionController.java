package com.example.tuCasita.controllers;

import com.example.tuCasita.dtos.ErrorDTO;
import com.example.tuCasita.exceptions.HomeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HomeExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(HomeException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
