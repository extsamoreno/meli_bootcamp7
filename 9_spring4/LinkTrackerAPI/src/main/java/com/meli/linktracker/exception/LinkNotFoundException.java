package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends LinkException{
    public LinkNotFoundException(int linkId){
        super("the link requested with link id "+linkId+ " doesnt exist", HttpStatus.BAD_REQUEST);
    }
}
