package com.example.LinkTracker.controller;

import com.example.LinkTracker.exceptions.ExistentLinkException;
import com.example.LinkTracker.exceptions.InvalidLinkException;
import com.example.LinkTracker.exceptions.LinkException;
import com.example.LinkTracker.exceptions.UnexistentLinkException;
import com.example.LinkTracker.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class LinksExceptionController {

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