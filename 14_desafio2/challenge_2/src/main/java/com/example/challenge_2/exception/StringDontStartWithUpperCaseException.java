package com.example.challenge_2.exception;

public class StringDontStartWithUpperCaseException extends Exception {
    public StringDontStartWithUpperCaseException(String field) {
        super(field.concat(" need to start with uppercase"));
    }
}
