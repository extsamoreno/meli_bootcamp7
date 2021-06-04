package com.meli.API_link_tracker.model.exception;

import org.springframework.http.HttpStatus;

public class LinkAlreadyInvalidatedException extends LinkTrackerException{
    public LinkAlreadyInvalidatedException(int linkId) {
        super("The link corresponding to id `"+ linkId + "` was invalidated", HttpStatus.NOT_FOUND);
    }
}