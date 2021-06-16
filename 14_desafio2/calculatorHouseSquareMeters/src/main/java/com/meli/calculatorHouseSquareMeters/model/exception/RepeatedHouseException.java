package com.meli.calculatorHouseSquareMeters.model.exception;

import org.springframework.http.HttpStatus;

public class RepeatedHouseException extends CalculatorHouseException{
    public RepeatedHouseException(String nameHouse) {
        super("The house with the name '" + nameHouse + "' already exists in the Database", HttpStatus.BAD_REQUEST);
    }
}
