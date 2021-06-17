package com.example.challenge_2.exception;

public class MaximunLengthExceededException extends Exception {
    public MaximunLengthExceededException(String field) {
        super(field.concat(" exceeded the maximun length"));
    }
}
