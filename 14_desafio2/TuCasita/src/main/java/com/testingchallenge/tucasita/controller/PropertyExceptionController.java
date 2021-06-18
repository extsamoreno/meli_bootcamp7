package com.testingchallenge.tucasita.controller;

import com.testingchallenge.tucasita.dto.ErrorDTO;
import com.testingchallenge.tucasita.exception.PropertyNotFoundException;
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
public class PropertyExceptionController {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalExceptions (PropertyNotFoundException exception){
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions (MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult()
                 .getAllErrors()
                 .forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                 });
        String message = errors.toString();
        return new ResponseEntity<>(new ErrorDTO
                (message, MethodArgumentNotValidException.class.getSimpleName()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException exception) {
        String message = exception.getMostSpecificCause().getMessage();
        return new ResponseEntity<>(new ErrorDTO
                (message, HttpMessageNotReadableException.class.getSimpleName()),
                HttpStatus.BAD_REQUEST);
    }
}
