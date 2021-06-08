package com.example.desafiospring.socialmeli.controller;

import com.example.desafiospring.socialmeli.service.DTO.ErrorDTO;
import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}