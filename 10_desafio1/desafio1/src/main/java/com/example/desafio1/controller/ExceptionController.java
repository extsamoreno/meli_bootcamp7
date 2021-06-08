package com.example.desafio1.controller;

import com.example.desafio1.exception.UserException;
import com.example.desafio1.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
