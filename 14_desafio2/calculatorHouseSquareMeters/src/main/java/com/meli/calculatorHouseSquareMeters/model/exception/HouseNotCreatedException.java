package com.meli.calculatorHouseSquareMeters.model.exception;

import org.springframework.http.HttpStatus;

public class HouseNotCreatedException extends CalculatorHouseException{
    public HouseNotCreatedException(String nameHouse) {
        super("The house with the name '" + nameHouse + "' was not created in the Database", HttpStatus.BAD_REQUEST);
    }
}
