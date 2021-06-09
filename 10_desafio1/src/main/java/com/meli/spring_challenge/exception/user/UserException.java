package com.meli.spring_challenge.exception.user;

import com.meli.spring_challenge.service.dto.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends Exception{
    private ErrorDto error;
    private HttpStatus status;

    UserException(String message, HttpStatus status){
        this.error = new ErrorDto();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
