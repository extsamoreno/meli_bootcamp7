package com.socialMeli.exceptions;

import com.socialMeli.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;

public class FailCreatePostException extends SocialMeliException {
    public FailCreatePostException(){
        super(new ErrorDTO("Fail Create Post Exception", "Fallo la creacion del post "), HttpStatus.BAD_REQUEST);
    }
}
