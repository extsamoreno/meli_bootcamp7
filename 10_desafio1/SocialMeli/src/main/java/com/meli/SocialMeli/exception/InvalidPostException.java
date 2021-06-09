package com.meli.SocialMeli.exception;

public class InvalidPostException extends ProductException{
    public InvalidPostException() {
        super("There is 1 or more invalid fields.");
    }
}
