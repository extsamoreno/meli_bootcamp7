package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

/**
 * Thrown if the date given does not match the type, format o pattern required
 */
public class InvalidDateException extends SocialMeliException {
    public InvalidDateException (LocalDate date){
        super(new ErrorDTO("Invalid Date Exception", "Fecha " + date.toString() + " invalida"), HttpStatus.BAD_REQUEST);
    }
}
