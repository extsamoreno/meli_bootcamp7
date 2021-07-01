package com.meli.consultorio.controllers;

import com.meli.consultorio.exceptions.ApiError;
import com.meli.consultorio.exceptions.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppointmentExceptionController {
    @ExceptionHandler(ApiException.class)
    ResponseEntity<ApiError> handleGlobalExceptions(ApiException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
