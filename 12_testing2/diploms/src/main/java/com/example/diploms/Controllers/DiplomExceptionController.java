package com.example.diploms.Controllers;

import com.example.diploms.Services.DTOs.ErrorDTO;
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
public class DiplomExceptionController {

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

}
