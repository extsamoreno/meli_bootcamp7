package com.example.MeliSocialApi.project.exception;

import com.example.MeliSocialApi.project.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class UserException extends Exception {

    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}