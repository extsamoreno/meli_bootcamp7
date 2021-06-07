package com.spring4.linktracker.exception;

import org.springframework.http.HttpStatus;

public class TrackerIdNotFoundException extends TrackerException {
    public TrackerIdNotFoundException(Integer id) {
        super("El id: "+ id +" no corresponde a ningun Link", HttpStatus.BAD_REQUEST);
    }
}

