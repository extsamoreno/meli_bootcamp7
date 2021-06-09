package com.example.desafio_1.exception;

public class NumberNotGreaterThanZero extends Exception{
    public NumberNotGreaterThanZero(String field) {
        super(field.concat(" must be greater than zero"));
    }
}
