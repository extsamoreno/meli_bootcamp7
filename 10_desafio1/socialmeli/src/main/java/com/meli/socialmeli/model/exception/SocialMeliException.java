package com.meli.socialmeli.model.exception;

import com.meli.socialmeli.model.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SocialMeliException extends Exception{
    private final ErrorDTO error;
    private final HttpStatus status;

    public SocialMeliException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
