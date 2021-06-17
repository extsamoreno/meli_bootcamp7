package com.bootcamp.desafio2.exception.district;

import com.bootcamp.desafio2.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends GeneralException {

    public DistrictNotFoundException(String district_name) {
        super("The District with the name: " +district_name+ " is not found in the DataBase.", HttpStatus.BAD_REQUEST);
    }
}
