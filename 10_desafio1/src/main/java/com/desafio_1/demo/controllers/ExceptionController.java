package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.ErrorDTO;
import com.desafio_1.demo.exceptions.BadRequestException;
import com.desafio_1.demo.exceptions.UnhandledException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UnhandledException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UnhandledException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(BadRequestException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
