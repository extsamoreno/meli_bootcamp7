package com.socialMeli.user.exceptions;

import com.socialMeli.user.models.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{

    public UserNotFoundException(Integer userId) {
        super(new ErrorDTO("User Not Found", "No se pudo encontrar el usuario con id " + userId), HttpStatus.BAD_REQUEST);
    }
}
