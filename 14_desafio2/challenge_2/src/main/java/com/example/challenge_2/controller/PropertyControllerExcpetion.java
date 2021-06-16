package com.example.challenge_2.controller;

import com.example.challenge_2.exception.PropertyException;
import com.example.challenge_2.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyControllerExcpetion {
    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<ErrorDTO> handlePostException(PropertyException exception) {
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }
}
