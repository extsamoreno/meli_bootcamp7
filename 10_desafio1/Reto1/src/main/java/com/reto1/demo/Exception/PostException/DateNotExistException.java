package com.reto1.demo.Exception.PostException;

import com.reto1.demo.Exception.GeneralException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Date;

public class DateNotExistException extends GeneralException {
    public DateNotExistException(LocalDate today, LocalDate date) {
        super("The date "+date+" still not exist. Today is "+today,
                HttpStatus.BAD_REQUEST);
    }
}
