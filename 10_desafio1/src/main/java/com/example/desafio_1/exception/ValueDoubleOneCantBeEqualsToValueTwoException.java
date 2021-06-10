package com.example.desafio_1.exception;

public class ValueDoubleOneCantBeEqualsToValueTwoException extends Exception {
    public ValueDoubleOneCantBeEqualsToValueTwoException(String fieldOne, String fieldTwo) {
        super("Value of:".concat(fieldOne).concat(" can't be equals to ").concat(fieldTwo));
    }
}
