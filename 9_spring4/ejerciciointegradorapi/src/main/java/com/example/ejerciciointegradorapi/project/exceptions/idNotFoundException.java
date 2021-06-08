package com.example.ejerciciointegradorapi.project.exceptions;

import org.springframework.http.HttpStatus;

public class idNotFoundException extends LinkTrackerException{

    public idNotFoundException(String id) {
        super("ID: "+id+" is not valid", HttpStatus.BAD_REQUEST);
    }

}