package com.api.linktracker.controller;

import com.api.linktracker.dto.ErrorDTO;
import com.api.linktracker.exception.IncorrectIdException;
import com.api.linktracker.exception.IncorrectPasswordException;
import com.api.linktracker.exception.InvalidatedLinkException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(IncorrectIdException.class)
    public ResponseEntity<ErrorDTO> incorrectIdException(IncorrectIdException e){
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ErrorDTO> incorrectPasswordException(IncorrectPasswordException e){
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }

    @ExceptionHandler(InvalidatedLinkException.class)
    public ResponseEntity<ErrorDTO> invalidatedLinkException (InvalidatedLinkException e){
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
}
