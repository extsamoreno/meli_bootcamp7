package com.meli.socialmeli.exception;

import com.meli.socialmeli.service.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message, HttpStatus status){
        this.error = new ErrorDTO(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
