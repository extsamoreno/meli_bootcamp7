package com.digitalhouse.obtenerdiploma.controller;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import com.digitalhouse.obtenerdiploma.exception.NotValidResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ControllerAdvice
public class ObtenerDiplomaExceptionController {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
            List<String> errors = new ArrayList<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String errorMessage = error.getDefaultMessage();
                errors.add(errorMessage);
            });
            ErrorDTO errorDTO = new ErrorDTO(MethodArgumentNotValidException.class.getSimpleName(),errors);
            return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
        }


    @ExceptionHandler(NotValidResponseException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(NotValidResponseException ex) {
        return new ResponseEntity<>(ex.getErrorDTO(), ex.getStatus());
    }
}
