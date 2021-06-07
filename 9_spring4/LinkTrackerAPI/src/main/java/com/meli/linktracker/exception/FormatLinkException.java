package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

public class FormatLinkException extends LinkException{
    public FormatLinkException(String link){
        super("The URL "+ link + "is not valid ", HttpStatus.BAD_REQUEST);
    }
}
