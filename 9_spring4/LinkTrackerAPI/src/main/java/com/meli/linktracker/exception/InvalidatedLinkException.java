package com.meli.linktracker.exception;

import com.meli.linktracker.model.Link;
import org.springframework.http.HttpStatus;

public class InvalidatedLinkException extends LinkException{
    public InvalidatedLinkException(Link link){
        super("The link with id "+link.getId()+" is already invalidated", HttpStatus.BAD_REQUEST);
    }
}
