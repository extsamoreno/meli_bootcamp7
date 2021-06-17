package com.meli.tucasita.controller;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DistrictControllerException {
    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DistrictNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
