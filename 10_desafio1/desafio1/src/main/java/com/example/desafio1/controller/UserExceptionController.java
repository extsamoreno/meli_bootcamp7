package com.example.desafio1.controller;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
