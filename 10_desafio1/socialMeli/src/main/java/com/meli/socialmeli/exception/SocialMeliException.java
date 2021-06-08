package com.meli.socialmeli.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SocialMeliException extends Exception {

    private ErrorDTO error;
    private HttpStatus status;

    public SocialMeliException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
