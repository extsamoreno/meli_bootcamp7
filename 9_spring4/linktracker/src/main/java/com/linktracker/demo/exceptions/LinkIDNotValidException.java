package com.linktracker.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkIDNotValidException extends ResponseException{
    public LinkIDNotValidException(int id){
        super("Link ID " + id + " is NOT valid.", HttpStatus.BAD_REQUEST);
    }
}
