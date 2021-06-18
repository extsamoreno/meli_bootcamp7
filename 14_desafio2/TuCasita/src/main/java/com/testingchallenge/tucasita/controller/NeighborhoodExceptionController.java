package com.testingchallenge.tucasita.controller;

import com.testingchallenge.tucasita.dto.ErrorDTO;
import com.testingchallenge.tucasita.exception.NeighborhoodNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NeighborhoodExceptionController {
    @ExceptionHandler(NeighborhoodNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException (NeighborhoodNotFoundException exception) {
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }
}
