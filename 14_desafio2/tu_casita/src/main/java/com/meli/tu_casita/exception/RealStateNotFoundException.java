package com.meli.tu_casita.exception;

import org.springframework.http.HttpStatus;

public class RealStateNotFoundException extends TuCasitaException{

    public RealStateNotFoundException(String realStateName, Integer realStateId) {
        super("Real state " + (realStateName != null ? realStateName:realStateId) + " not found", HttpStatus.BAD_REQUEST);
    }
}
