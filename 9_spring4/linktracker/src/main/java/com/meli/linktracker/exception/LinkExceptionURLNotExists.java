package com.meli.linktracker.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class LinkExceptionURLNotExists extends LinkException {

    public LinkExceptionURLNotExists(int linkId) {
        super("Link id: " + linkId + " does not exits ",
                NOT_FOUND);
    }

}
