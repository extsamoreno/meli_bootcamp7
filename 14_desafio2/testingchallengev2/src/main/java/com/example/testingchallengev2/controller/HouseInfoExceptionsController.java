package com.example.testingchallengev2.controller;

import com.example.testingchallengev2.exception.DistrictNotFoundException;
import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HouseInfoExceptionsController {

    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(HouseNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(DistrictNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
