package com.example.desafio_1.controller;

import com.example.desafio_1.exception.UserException;
import com.example.desafio_1.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDTO> handleUserException(UserException exception) {
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }
}
