package com.meli.spring.exceptions;

import org.springframework.http.HttpStatus;

public class LinkIDNotFoundException extends LinkException {
    public LinkIDNotFoundException(String linkID) {
        super("El linkdID: "+linkID+" no corresponde a ninguna Pagina", HttpStatus.NOT_FOUND);
    }
}
