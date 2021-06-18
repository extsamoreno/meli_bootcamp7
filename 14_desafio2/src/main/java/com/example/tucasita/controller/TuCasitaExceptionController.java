package com.example.tucasita.controller;

import com.example.tucasita.exception.DistrictException;
import com.example.tucasita.exception.PropertyException;
import com.example.tucasita.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TuCasitaExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyException.class)
    ResponseEntity<ErrorDTO> handleGlobalPropertyExceptions(PropertyException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictException.class)
    ResponseEntity<ErrorDTO> handleGlobalDistrictExceptions(DistrictException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}