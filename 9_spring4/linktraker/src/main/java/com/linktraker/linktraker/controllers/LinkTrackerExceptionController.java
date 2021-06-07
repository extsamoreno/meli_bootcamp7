package com.linktraker.linktraker.controllers;

import com.linktraker.linktraker.exceptions.*;
import com.linktraker.linktraker.services.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkTrackerExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkTrackerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DisableException.class)
    public ResponseEntity<ErrorDTO> handleDisableException(DisableException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ErrorDTO> handleIncorrectPasswordException(IncorrectPasswordException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleLinkIdNotFoundException(LinkIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkNotExistException.class)
    public ResponseEntity<ErrorDTO> handleLinkNotExistException(LinkNotExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkTrackerException.class)
    public ResponseEntity<ErrorDTO> handleLinkTrackerException(LinkTrackerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}

