package com.example.desafio_1.exception;

public class DateExceptionInvalidFormat extends Exception {
    public DateExceptionInvalidFormat(String field) {
        super(field.concat(" has wrong format, must have dd/MM/yyyy format"));
    }
}
