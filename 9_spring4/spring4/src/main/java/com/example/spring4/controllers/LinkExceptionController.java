package com.example.spring4.controllers;

import com.example.spring4.dtos.ErrorDTO;
import com.example.spring4.exceptions.InvalidPasswordException;
import com.example.spring4.exceptions.InvalidURLException;
import com.example.spring4.exceptions.URLNotFoundException;
import com.example.spring4.exceptions.UnreachableURLException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<ErrorDTO> handlerInvalidURL(InvalidURLException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(URLNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerURLNotFound(URLNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UnreachableURLException.class)
    public ResponseEntity<ErrorDTO> handlerUnreachableURL(UnreachableURLException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorDTO> handlerInvalidPassword(InvalidPasswordException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}