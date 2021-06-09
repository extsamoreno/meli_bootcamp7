package com.springChallenge.api.controller.exception.product;

import com.springChallenge.api.controller.exception.GlobalException;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

public class IDPostAlreadyUsed extends GlobalException {
    public IDPostAlreadyUsed(Integer idPost){
        super(MessageFormat.format("The idPost ''{0}'' is already being used", idPost), HttpStatus.BAD_REQUEST);
    }
}
