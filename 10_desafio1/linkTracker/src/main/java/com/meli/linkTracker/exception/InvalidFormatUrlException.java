package com.meli.linkTracker.exception;

public class InvalidFormatUrlException extends UrlException{
    public InvalidFormatUrlException() {
        super("The provided URL does not follow the correct structure");
    }
}
