package com.spring4.ejercicios.link.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkException extends Exception {

    private ErrorDTO error;
    private HttpStatus status;

    public LinkException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setName(this.getClass().getSimpleName());
        this.error.setMessage(message);
        this.status = status;
    }
}
