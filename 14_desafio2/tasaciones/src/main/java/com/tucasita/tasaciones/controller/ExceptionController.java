package com.tucasita.tasaciones.controller;

import com.tucasita.tasaciones.dto.ErrorResponse;
import com.tucasita.tasaciones.exception.PropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<ErrorResponse> handlePropertyException(PropertyException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> handleIOException(IOException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), "IOException"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
