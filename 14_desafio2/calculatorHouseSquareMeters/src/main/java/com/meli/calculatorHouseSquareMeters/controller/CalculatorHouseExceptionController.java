package com.meli.calculatorHouseSquareMeters.controller;

import com.meli.calculatorHouseSquareMeters.model.dto.ErrorDTO;
import com.meli.calculatorHouseSquareMeters.model.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CalculatorHouseExceptionController {
    @ExceptionHandler(CalculatorHouseException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException (CalculatorHouseException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictNotCreatedException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNotCreatedException (DistrictNotCreatedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNotFoundException (DistrictNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(HouseNotCreatedException.class)
    public ResponseEntity<ErrorDTO> handleHouseNotCreatedException (HouseNotCreatedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleHouseNotFoundException (HouseNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(RepeatedDistrictException.class)
    public ResponseEntity<ErrorDTO> handleRepeatedDistrictException (RepeatedDistrictException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(RepeatedHouseException.class)
    public ResponseEntity<ErrorDTO> handleRepeatedHouseException (RepeatedHouseException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
