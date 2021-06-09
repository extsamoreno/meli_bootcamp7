package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class WrongOrderFieldException extends WebException{
    public WrongOrderFieldException(String orderCriteria) {
        super("The order".concat(orderCriteria).concat("criteria does not correspond to any of the criteria"), HttpStatus.BAD_REQUEST);
    }
}
