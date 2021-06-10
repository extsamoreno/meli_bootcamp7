package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

/**
 * Thrown when the user given does not match with any value in the users or sellers HashMap
 */
public class UserIdNotFoundException extends SocialMeliException{
    public UserIdNotFoundException(){
        super(new ErrorDTO("User ID Not Found", "No se pudo encontrar el ID del usuario "), HttpStatus.BAD_REQUEST);
    }
}
