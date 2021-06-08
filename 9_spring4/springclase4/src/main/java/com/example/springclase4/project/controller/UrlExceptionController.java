package com.example.springclase4.project.controller;

import com.example.springclase4.project.exception.UrlAlreadyExistException;
import com.example.springclase4.project.exception.UrlNotFoundException;
import com.example.springclase4.project.repository.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlExceptionController {

    @ExceptionHandler(UrlAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleException(UrlAlreadyExistException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(UrlNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
