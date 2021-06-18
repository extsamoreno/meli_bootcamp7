package com.meli.tuCasita.controller;

import com.meli.tuCasita.exception.DistrictNotFoundException;
import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HouseExceptionController {

    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(HouseNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DistrictNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
