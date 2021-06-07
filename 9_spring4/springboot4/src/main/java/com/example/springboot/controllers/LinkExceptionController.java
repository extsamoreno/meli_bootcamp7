package com.example.springboot.controllers;

import com.example.springboot.dtos.ErrorDTO;
import com.example.springboot.exceptions.InvalidPasswordException;
import com.example.springboot.exceptions.InvalidURLException;
import com.example.springboot.exceptions.URLNotFoundException;
import com.example.springboot.exceptions.UnreachableURLException;
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
