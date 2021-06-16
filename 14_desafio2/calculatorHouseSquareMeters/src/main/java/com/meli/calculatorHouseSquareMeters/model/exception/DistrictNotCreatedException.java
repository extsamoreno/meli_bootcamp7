package com.meli.calculatorHouseSquareMeters.model.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotCreatedException extends CalculatorHouseException{
    public DistrictNotCreatedException(String nameDistric) {
        super("The district with the name '" + nameDistric + "' was not created in the Database", HttpStatus.BAD_REQUEST);
    }
}
