package com.meli.calculatorHouseSquareMeters.model.exception;

import org.springframework.http.HttpStatus;

public class HouseNotFoundException extends CalculatorHouseException{
    public HouseNotFoundException(String nameHouse) {
        super("The house with the name '" + nameHouse + "' was not found in the Database", HttpStatus.NOT_FOUND);
    }
}
