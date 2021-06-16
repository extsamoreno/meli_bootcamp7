package com.meli.desafio1.web.exception;

import com.meli.desafio1.web.exception.PostException;
import org.springframework.http.HttpStatus;

public class PostOrderNotValidException extends PostException {
    public PostOrderNotValidException(String message, HttpStatus status) {
        super("The order parameter " + message + " is invalid.", status);
    }
}
