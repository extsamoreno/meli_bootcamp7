package com.SocialMeli.exceptions;

import com.SocialMeli.dtos.FollowedUserDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class UsersCantFollowThemselvesException extends Throwable {

    private ErrorDTO error;
    private HttpStatus status;

    public UsersCantFollowThemselvesException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }

    public UsersCantFollowThemselvesException(int userId) {
    }
}