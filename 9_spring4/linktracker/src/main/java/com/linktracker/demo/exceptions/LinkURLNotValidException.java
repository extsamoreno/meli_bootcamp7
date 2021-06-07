package com.linktracker.demo.exceptions;
import org.springframework.http.HttpStatus;

public class LinkURLNotValidException extends ResponseException {
    public LinkURLNotValidException(String url) {
        super("URL "+ url +" is NOT valid.", HttpStatus.BAD_REQUEST);
    }
}