package com.digitalhouse.obtenerdiploma.controller;


import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ObtenerDiplomaExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ArrayList<ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        var errorDTO = new ArrayList<ErrorDTO>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            var err = new ErrorDTO();
            err.setNombre(((FieldError) error).getField());
            err.setMensaje(error.getDefaultMessage());
            errorDTO.add(err);
        });

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}


