package com.example.desafio_1.exception;

public class WrongValueInFieldException extends Exception{
    public WrongValueInFieldException(String field, String correctValue) {
        super("The value in ".concat(field).concat(" must be ").concat(correctValue));
    }
}
