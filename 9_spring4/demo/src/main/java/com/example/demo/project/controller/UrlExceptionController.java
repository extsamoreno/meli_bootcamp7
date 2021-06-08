package com.example.demo.project.controller;

import com.example.demo.project.exception.UrlException;
import com.example.demo.project.exception.UrlIdNotFoundException;
import com.example.demo.project.exception.UrlNotValidException;
import com.example.demo.project.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UrlException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UrlIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UrlIdNotFoundException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UrlNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UrlNotValidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
