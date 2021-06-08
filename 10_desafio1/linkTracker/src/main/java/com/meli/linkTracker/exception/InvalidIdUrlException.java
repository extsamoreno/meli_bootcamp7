package com.meli.linkTracker.exception;

public class InvalidIdUrlException extends UrlException{
    public InvalidIdUrlException() {
        super("The provided ID is not valid");
    }
}
