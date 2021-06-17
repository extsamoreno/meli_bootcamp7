package com.example.DesafioTasaciones.controllers;

import com.example.DesafioTasaciones.exceptions.Error;
import com.example.DesafioTasaciones.exceptions.ErrorException;
import com.example.DesafioTasaciones.exceptions.ErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HouseExceptionController {

    @ExceptionHandler(ErrorException.class)
    ResponseEntity<Error> handleGlobalExceptions(ErrorException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Error> handleValidationExceptions(MethodArgumentNotValidException e) {
        Error error = new Error("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Error> handleValidationExceptions(HttpMessageNotReadableException e) {
        Error error = new Error("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
