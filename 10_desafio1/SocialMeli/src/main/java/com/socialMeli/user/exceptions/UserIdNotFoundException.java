package com.socialMeli.user.exceptions;

import com.socialMeli.user.models.ErrorDTO;
import com.socialMeli.user.models.User;
import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends UserException{
    public UserIdNotFoundException(){
        super(new ErrorDTO("User ID Not Found", "No se pudo encontrar el ID del usuario "), HttpStatus.BAD_REQUEST);
    }
}
