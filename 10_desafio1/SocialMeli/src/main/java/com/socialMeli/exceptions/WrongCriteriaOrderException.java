package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

public class WrongCriteriaOrderException extends SocialMeliException {
    public WrongCriteriaOrderException() {
        super(new ErrorDTO("Wrong Criteria Order", "El criterio de orden es incorrecto "), HttpStatus.BAD_REQUEST);
    }
}
