package com.example.testing.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class DistrictNotFoundException extends PropertyException {

    public DistrictNotFoundException(String name) {
        super("The district " + name + " is not registered.", HttpStatus.NOT_FOUND);
    }
}
