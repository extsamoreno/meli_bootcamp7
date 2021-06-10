package com.SocialMeli.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserInvalidException {

    private ErrorDTO error;
    private HttpStatus status;

    public UserInvalidException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}