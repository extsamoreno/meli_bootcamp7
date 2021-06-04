package com.linktracker.demo.exceptions;
import org.springframework.http.HttpStatus;

public class LinkInvalidException extends ResponseException {
    public LinkInvalidException(String url) {
        super("La url "+ url +" es invalida.", HttpStatus.BAD_REQUEST);
    }
}