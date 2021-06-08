package com.exceptions;

import com.models.ErrorDTO;
import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends Exception{
    public LinkNotFoundException(String url) {
        super(new ErrorDTO("Link Not Found", "No se encontro el link " + url), HttpStatus.NOT_FOUND);
    }
}
