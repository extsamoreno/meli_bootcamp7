package com.example.desafio_1.exception;

public class ValueDoubleOneCantBeGreaterThanValueTwoException extends Exception {
    public ValueDoubleOneCantBeGreaterThanValueTwoException(String fieldOne, String fieldTwo) {
        super("Value of:".concat(fieldOne).concat(" can't be greater than ").concat(fieldTwo));
    }
}
