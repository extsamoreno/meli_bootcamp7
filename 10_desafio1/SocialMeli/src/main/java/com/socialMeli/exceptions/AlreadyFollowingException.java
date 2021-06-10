package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

/**
 * Thrown if a user already follows the seller with the user id given
 */
public class AlreadyFollowingException extends SocialMeliException {
    public AlreadyFollowingException(String username){
        super(new ErrorDTO("Already Following Exception", "El usuario " + username + " ya sigue al vendedor solicitado"), HttpStatus.BAD_REQUEST);
    }
}
