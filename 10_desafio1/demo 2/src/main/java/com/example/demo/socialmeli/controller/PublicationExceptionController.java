package com.example.demo.socialmeli.controller;

import com.example.demo.socialmeli.exception.InvalidityDateException;
import com.example.demo.socialmeli.exception.MissingParameterException;
import com.example.demo.socialmeli.exception.PublicationExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
import com.example.demo.socialmeli.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PublicationExceptionController {
    @ExceptionHandler(PublicationExistingException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PublicationExistingException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
    @ExceptionHandler(MissingParameterException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(MissingParameterException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
    @ExceptionHandler(InvalidityDateException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidityDateException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
}
