package com.example.linktracker.controllers;

import com.example.linktracker.dtos.ErrorDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import com.example.linktracker.exceptions.LinkException;
import com.example.linktracker.exceptions.UnexistentLinkException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinksTrackerExceptionController {

    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(ExistentLinkException.class)
    public ResponseEntity<ErrorDTO> handleExistentLinkException(ExistentLinkException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ErrorDTO> handleInvalidExcepcionException(InvalidLinkException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(UnexistentLinkException.class)
    public ResponseEntity<ErrorDTO> handleExistentLinkException(UnexistentLinkException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }
}
