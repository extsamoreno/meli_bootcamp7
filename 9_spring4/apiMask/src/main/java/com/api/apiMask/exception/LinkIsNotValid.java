package com.api.apiMask.exception;

import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

public class LinkIsNotValid extends LinkValidationException{
    public LinkIsNotValid(long linkId){
        super(MessageFormat.format("The link with linkId ''{0}'' is not valid", linkId), HttpStatus.NOT_FOUND);
    }
}
