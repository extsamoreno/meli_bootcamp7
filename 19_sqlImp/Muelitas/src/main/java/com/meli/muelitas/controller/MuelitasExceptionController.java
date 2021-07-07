package com.meli.muelitas.controller;

import com.meli.muelitas.dto.ErrorDTO;
import com.meli.muelitas.exception.MuelitasException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MuelitasExceptionController {

    @ExceptionHandler(MuelitasException.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(MuelitasException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

}
