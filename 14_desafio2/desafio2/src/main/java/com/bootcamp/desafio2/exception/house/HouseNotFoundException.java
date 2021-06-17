package com.bootcamp.desafio2.exception.house;

import com.bootcamp.desafio2.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class HouseNotFoundException extends GeneralException {

    public HouseNotFoundException(String prop_name) {
        super("The Property with the name: " +prop_name+ " is not found in the DataBase.", HttpStatus.BAD_REQUEST);
    }

}
