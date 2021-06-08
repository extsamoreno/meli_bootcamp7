package com.example.ejerciciointegradorapi.project.exceptions;

import org.springframework.http.HttpStatus;


public class InvalidUrlException extends LinkTrackerException{

        public InvalidUrlException(String url) {
            super("URL: "+url+" is not valid", HttpStatus.BAD_REQUEST);
        }

}
