package com.example.Challenge.controller;


import com.example.Challenge.dto.ErrorDTO;
import com.example.Challenge.exception.ProductException;
import com.example.Challenge.exception.ProgramException;
import com.example.Challenge.exception.UserIdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProgramExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProgramException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
