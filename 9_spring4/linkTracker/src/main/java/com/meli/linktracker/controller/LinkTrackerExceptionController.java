package com.meli.linktracker.controller;

import com.meli.linktracker.exception.ErrorDTO;
import com.meli.linktracker.exception.IdNotFoundException;
import com.meli.linktracker.exception.InvalidURLException;
import com.meli.linktracker.exception.LinkException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkTrackerExceptionController {

    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidURLException e) {

        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(IdNotFoundException e) {

        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}