package com.linktracker.linktracker.exceptions;
import org.springframework.http.HttpStatus;

public class LinkNotValidToRedirectException extends LinkException{
        public LinkNotValidToRedirectException(String message) {
            super(message, HttpStatus.NOT_FOUND);
        }
}
