package com.digitalhouse.obtenerdiploma.controller;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import com.digitalhouse.obtenerdiploma.exception.AnalyzeNotesException;
import com.digitalhouse.obtenerdiploma.exception.DuplicateSubjectNameException;
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
public class AnalizeNotesExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(AnalyzeNotesException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

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
    public ResponseEntity<?> HttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("Bad json",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateSubjectNameException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DuplicateSubjectNameException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
