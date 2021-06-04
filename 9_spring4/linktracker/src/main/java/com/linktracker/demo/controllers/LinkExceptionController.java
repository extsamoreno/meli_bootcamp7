package com.linktracker.demo.controllers;

import com.linktracker.demo.dtos.ErrorDTO;
import com.linktracker.demo.exceptions.LinkException;
import com.linktracker.demo.exceptions.LinkInvalidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}

