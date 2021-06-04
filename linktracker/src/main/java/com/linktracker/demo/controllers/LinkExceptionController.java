package com.linktracker.demo.controllers;

import com.linktracker.demo.dtos.ErrorDTO;
import com.linktracker.demo.exceptions.LinkAlreadyExistException;
import com.linktracker.demo.exceptions.LinkInvalidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    //TODO: preguntar si se hace un controller de excepcion por cada controller o uno solo general.
    @ExceptionHandler(LinkInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkAlreadyExistException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}

