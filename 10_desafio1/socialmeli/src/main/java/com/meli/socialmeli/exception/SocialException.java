package com.meli.socialmeli.exception;

import com.meli.socialmeli.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SocialException extends Exception {

    private final ErrorDTO error;
    private final HttpStatus status;

    public SocialException(String message, HttpStatus status) {
        this.error = new ErrorDTO(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
