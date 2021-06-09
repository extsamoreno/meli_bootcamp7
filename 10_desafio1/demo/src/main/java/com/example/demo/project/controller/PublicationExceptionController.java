package com.example.demo.project.controller;

import com.example.demo.project.exception.*;
import com.example.demo.project.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PublicationExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DuplicatedPublicationIdException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DuplicatedPublicationIdException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PublicationIsNotPromoException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PublicationIsNotPromoException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(CantInsertDateGreaterThanToday.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(CantInsertDateGreaterThanToday e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
