package com.bootcamp.desafio2.exception.house;

import com.bootcamp.desafio2.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class HouseAlreadyExistsException extends GeneralException {

    public HouseAlreadyExistsException(String prop_name) {
        super("The Property with name: " +prop_name+ " already exists in the DataBase.", HttpStatus.BAD_REQUEST);
    }
}
