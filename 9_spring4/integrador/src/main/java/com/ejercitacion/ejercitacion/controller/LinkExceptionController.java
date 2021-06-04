package com.ejercitacion.ejercitacion.controller;

import com.ejercitacion.ejercitacion.dto.ErrorResponse;
import com.ejercitacion.ejercitacion.exception.InvalidLinkPasswordException;
import com.ejercitacion.ejercitacion.exception.LinkException;
import com.ejercitacion.ejercitacion.exception.LinkIdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {


    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorResponse> handleLinkException(LinkException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(LinkIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLinkIdNotFoundException(LinkIdNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidLinkPasswordException.class)
    public ResponseEntity<ErrorResponse> handleInvalidLinkPasswordException(InvalidLinkPasswordException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
