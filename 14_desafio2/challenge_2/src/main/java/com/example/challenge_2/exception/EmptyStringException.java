package com.example.challenge_2.exception;

public class EmptyStringException extends Exception {
    public EmptyStringException(String field) {
        super(field.concat(" cant't be empty"));
    }
}
