package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Services.DTOs.ErrorDTO;
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


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, ErrorDTO> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            ErrorDTO errorMessage = new ErrorDTO(error.getDefaultMessage(),ex.getClass().getSimpleName());
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleNotReadableExceptions(HttpMessageNotReadableException ex) {

        return new ResponseEntity<>(new ErrorDTO(ex.getMessage(), ex.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handlePropertyNotFoundException(PropertyNotFoundException e) {
        return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
    }

}
