package com.meli.desafio2.controller;

import com.meli.desafio2.dto.ErrorDTO;
import com.meli.desafio2.exception.PropertyException;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PropertyException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
