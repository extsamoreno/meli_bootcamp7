package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

/**
 * Thrown if the criteria order has any value but "name_asc" or "name_desc"
 */
public class WrongCriteriaOrderException extends SocialMeliException {
    public WrongCriteriaOrderException() {
        super(new ErrorDTO("Wrong Criteria Order", "El criterio de orden es incorrecto "), HttpStatus.BAD_REQUEST);
    }
}
