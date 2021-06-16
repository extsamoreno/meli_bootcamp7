package com.meli.calculatorHouseSquareMeters.model.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends CalculatorHouseException{
    public DistrictNotFoundException(String nameDistrict) {
        super("The district with the name '" + nameDistrict + "' was not found in the Database", HttpStatus.NOT_FOUND);
    }
}
