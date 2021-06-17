package com.example.desafio2.controllers;

import com.example.desafio2.dtos.ErrorDTO;
import com.example.desafio2.exceptions.DistrictIdNotValidException;
import com.example.desafio2.exceptions.PropertyIdNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class PropertyExceptionController {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage(),e.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyIdNotValidException.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(PropertyIdNotValidException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
