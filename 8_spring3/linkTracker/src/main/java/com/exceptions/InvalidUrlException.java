package com.exceptions;

import com.models.ErrorDTO;
import org.springframework.http.HttpStatus;

public class InvalidUrlException extends Exception {
    public InvalidUrlException(String url) {
        super(new ErrorDTO("Invalid Url", "El URL " + url + " es invalido"), HttpStatus.CONFLICT);
    }
}
