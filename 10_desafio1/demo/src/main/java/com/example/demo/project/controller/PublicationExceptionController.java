package com.example.demo.project.controller;

import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.UserException;
import com.example.demo.project.exception.UserIdNotFoundException;
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
}
