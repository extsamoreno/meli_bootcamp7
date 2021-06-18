package com.example.challenge_2.controller;

import com.example.challenge_2.exception.DistrictException;
import com.example.challenge_2.exception.PropertyException;
import com.example.challenge_2.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyControllerException {
    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<ErrorDTO> handlePostException(PropertyException exception) {
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }

    @ExceptionHandler(DistrictException.class)
    public ResponseEntity<ErrorDTO> handlePostExceptionDistrictNotFound(DistrictException exception) {
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handlePostValidation(MethodArgumentNotValidException exception) {
        ErrorDTO error = new ErrorDTO(exception.getBindingResult().getFieldError().getDefaultMessage(), "MethodArgumentNotValidException");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
