package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

/**
 * Thrown if the id give does not exist either in users or sellers HashMap, depending on the case
 */
public class UserNotFoundException extends SocialMeliException{

    public UserNotFoundException(Integer userId) {
        super(new ErrorDTO("User Not Found", "No se pudo encontrar el usuario con id " + userId), HttpStatus.BAD_REQUEST);
    }
}
