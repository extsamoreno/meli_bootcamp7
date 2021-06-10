package com.meli.socialmeli.exceptions;

import com.meli.socialmeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserItselfException extends UserException{
    public UserItselfException() {
        super("No es posible autoseguirse.", HttpStatus.BAD_REQUEST);
    }
}
