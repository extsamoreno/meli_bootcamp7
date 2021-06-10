package com.desafiospring.socialMeli.exceptions;

import com.desafiospring.socialMeli.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends Exception {
    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public UserException(String message, HttpStatus httpStatus) {
        this.errorDTO = new ErrorDTO();
        this.errorDTO.setMessage(message);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = httpStatus;
    }
}