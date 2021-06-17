package com.meli.tucasita.controller;

import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.service.dto.ErrorDTO;
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
public class PropertyControllerException {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PropertyNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        String message=errors.toString();

        return new ResponseEntity<>(new ErrorDTO(message,MethodArgumentNotValidException.class.getSimpleName()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException ex) {
        String message=ex.getMostSpecificCause().getMessage();
        return new ResponseEntity<>(new ErrorDTO(message,HttpMessageNotReadableException.class.getSimpleName()), HttpStatus.BAD_REQUEST);
    }
}
