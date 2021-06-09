package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class InvalidDateException extends SocialMeliException {
    public InvalidDateException (LocalDate date){
        super(new ErrorDTO("Invalid Date Exception", "Fecha " + date.toString() + " invalida"), HttpStatus.BAD_REQUEST);

    }
}
