package com.meli.linktracker.controller;

import com.meli.linktracker.exception.*;
import com.meli.linktracker.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

    @ExceptionHandler(FormatLinkException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(FormatLinkException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidCredentialsException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
    @ExceptionHandler(InvalidatedLinkException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidatedLinkException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
