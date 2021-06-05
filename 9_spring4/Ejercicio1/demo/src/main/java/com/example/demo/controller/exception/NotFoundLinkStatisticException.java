package com.example.demo.controller.exception;

import org.springframework.http.HttpStatus;

public class NotFoundLinkStatisticException extends GenericException{
    public NotFoundLinkStatisticException(String linkId) {
        super("No ha sido redireccionado ninguna URL con codido " + linkId, HttpStatus.NOT_FOUND);
    }
}
