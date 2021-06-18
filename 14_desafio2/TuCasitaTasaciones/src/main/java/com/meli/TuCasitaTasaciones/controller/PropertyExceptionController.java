package com.meli.TuCasitaTasaciones.controller;

import com.meli.TuCasitaTasaciones.exception.DistrictRepeatedException;
import com.meli.TuCasitaTasaciones.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class PropertyExceptionController {

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

    @ExceptionHandler(DistrictRepeatedException.class)
    ResponseEntity<ErrorDTO> responseEntityExceptions(DistrictRepeatedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
//        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}
