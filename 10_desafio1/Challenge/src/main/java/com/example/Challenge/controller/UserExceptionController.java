package com.example.Challenge.controller;


import com.example.Challenge.dto.ErrorDTO;
import com.example.Challenge.exception.UserException;
import com.example.Challenge.exception.UserIdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
