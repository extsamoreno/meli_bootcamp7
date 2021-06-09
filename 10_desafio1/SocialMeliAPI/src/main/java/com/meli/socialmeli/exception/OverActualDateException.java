package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Date;

public class OverActualDateException extends PostException{

    public OverActualDateException(Date date){
        super("The specified date "+date.toString()+" is over the actual date "+LocalDate.now().toString(), HttpStatus.BAD_REQUEST);
    }
}
