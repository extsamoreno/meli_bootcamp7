package com.example.demo.controllers;

import com.example.demo.dtos.ErrorDTO;
import com.example.demo.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserAlreadyFollowException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserAlreadyFollowException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
