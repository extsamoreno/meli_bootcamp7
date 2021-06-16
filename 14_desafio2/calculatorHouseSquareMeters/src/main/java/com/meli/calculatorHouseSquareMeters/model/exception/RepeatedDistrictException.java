package com.meli.calculatorHouseSquareMeters.model.exception;

import org.springframework.http.HttpStatus;

public class RepeatedDistrictException extends CalculatorHouseException{
    public RepeatedDistrictException(String nameDistrict) {
        super("The district with the name '" + nameDistrict + "' already exists in the Database", HttpStatus.BAD_REQUEST);
    }
}
