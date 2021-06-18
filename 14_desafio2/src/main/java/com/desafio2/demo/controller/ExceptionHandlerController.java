package com.desafio2.demo.controller;

import com.desafio2.demo.dtos.ErrorDTO;
import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {

    /**
     * property not found
     */
    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerPropertyNotFoundException(PropertyNotFoundException  e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    /**
     * neighborhood not found
     */
    @ExceptionHandler(NeighborhoodNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNeighborhoodNotFoundException(NeighborhoodNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    /**
     * property already exist
     */
    @ExceptionHandler(PropertyAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handlerPropertyAlreadyExistException(PropertyAlreadyExistException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    /**
     * neighborhood already exist
     */
    @ExceptionHandler(NeighborhoodAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handlerNeighborhoodAlreadyExistException(NeighborhoodAlreadyExistException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    /**
     * not valid
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
