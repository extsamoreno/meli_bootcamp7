package com.bootcamp.desafio1.controller;


import com.bootcamp.desafio1.dto.ErrorDTO;
import com.bootcamp.desafio1.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity(e.getError(), e.getStatus());
    }
}
