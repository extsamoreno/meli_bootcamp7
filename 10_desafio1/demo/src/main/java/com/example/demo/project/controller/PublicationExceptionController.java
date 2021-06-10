package com.example.demo.project.controller;

import com.example.demo.project.exception.*;
import com.example.demo.project.service.dto.ErrorDTO;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), ex.getClass().getSimpleName()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleDateExceptions(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage().split(" \\(")[0], ex.getClass().getSimpleName()),HttpStatus.BAD_REQUEST);
    }
}
