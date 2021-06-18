package com.example.demo.controller;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.ExistingDistrictException;
import com.example.demo.exception.ExistingHouseException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DistrictNotFoundException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(HouseNotFoundException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
    @ExceptionHandler(ExistingHouseException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ExistingHouseException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
    @ExceptionHandler(ExistingDistrictException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ExistingDistrictException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
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
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage(), e.getClass().getSimpleName()),
                HttpStatus.BAD_REQUEST);
    }
}
