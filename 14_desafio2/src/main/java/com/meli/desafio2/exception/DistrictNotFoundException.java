package com.meli.desafio2.exception;

import com.meli.desafio2.model.District;
import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends PropertyException{
    public DistrictNotFoundException(District district) {
        super("The district " + district.getId() + " not exist in the database", HttpStatus.NOT_FOUND);
    }
}
