package com.socialmedia.socialmedia.exceptions;

import com.socialmedia.socialmedia.services.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SocialMediaException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;

    public SocialMediaException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}
