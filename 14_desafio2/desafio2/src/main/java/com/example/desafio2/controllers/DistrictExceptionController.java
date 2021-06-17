package com.example.desafio2.controllers;

import com.example.desafio2.dtos.ErrorDTO;
import com.example.desafio2.exceptions.DistrictIdNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DistrictExceptionController {
    @ExceptionHandler(DistrictIdNotValidException.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(DistrictIdNotValidException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
