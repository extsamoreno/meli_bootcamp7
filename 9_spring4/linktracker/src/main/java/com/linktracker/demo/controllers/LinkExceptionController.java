package com.linktracker.demo.controllers;

import com.linktracker.demo.dtos.ErrorDTO;
import com.linktracker.demo.exceptions.LinkAlreadyExistException;
import com.linktracker.demo.exceptions.LinkIDNotValidException;
import com.linktracker.demo.exceptions.LinkURLNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(LinkURLNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkURLNotValidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkIDNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkIDNotValidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}

