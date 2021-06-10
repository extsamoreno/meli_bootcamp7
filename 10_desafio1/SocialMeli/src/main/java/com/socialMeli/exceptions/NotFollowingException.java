package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

/**
 * Thrown if the user tries to unfollow a seller it is not following
 */
public class NotFollowingException extends SocialMeliException{
    public NotFollowingException(String username){
        super(new ErrorDTO("Not Following Exception", "El usuario " + username + " no sigue al vendedor solicitado"), HttpStatus.BAD_REQUEST);
    }
}
