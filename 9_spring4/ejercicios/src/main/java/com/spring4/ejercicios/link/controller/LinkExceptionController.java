package com.spring4.ejercicios.link.controller;

import com.spring4.ejercicios.link.exception.ErrorDTO;
import com.spring4.ejercicios.link.exception.IdNotFoundException;
import com.spring4.ejercicios.link.exception.InvalidLinkException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {


    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ErrorDTO> handleInvalidLinkException(InvalidLinkException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleIdNotFoundException(IdNotFoundException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }

}
