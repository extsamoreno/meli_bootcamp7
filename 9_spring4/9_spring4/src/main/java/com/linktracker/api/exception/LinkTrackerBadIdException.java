package com.linktracker.api.exception;
import org.springframework.http.HttpStatus;

public class LinkTrackerBadIdException extends LinkTrackerException {
    public LinkTrackerBadIdException(Integer id) {
        super("El id: "+ id + " no corresponde a ningun link", HttpStatus.FORBIDDEN);
    }
}
