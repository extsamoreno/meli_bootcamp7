package com.digitalhouse.obtenerdiploma.controller;


import com.digitalhouse.obtenerdiploma.Exception.ErrorDTO;
import com.digitalhouse.obtenerdiploma.Exception.ErrorDTOString;
import com.digitalhouse.obtenerdiploma.Exception.LowAverageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ObtenerDiplomaExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handlerException(MethodArgumentNotValidException e){
        return new ResponseEntity(new ErrorDTO(e.getAllErrors(), e.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LowAverageException.class)
    public ResponseEntity<ErrorDTO> handlerException(LowAverageException e){
        return new ResponseEntity(new ErrorDTOString(e.getMessage(), e.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }
}
