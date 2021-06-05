package com.example.demo.controller.exception;

import org.springframework.http.HttpStatus;

public class ExistLinkException extends GenericException{
    public ExistLinkException(String url, String linkId) {
        super("Ya existe un linkId para la url " + url + " y es " + linkId, HttpStatus.BAD_REQUEST);
    }
}
