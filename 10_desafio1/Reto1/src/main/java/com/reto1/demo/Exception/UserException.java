package com.reto1.demo.Exception;

import com.reto1.demo.Model.DTO.ErrorDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class UserException extends Exception{
    ErrorDTO error;
    HttpStatus status;

    public UserException(String message, HttpStatus status){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(message);
        errorDTO.setName(this.getClass().getSimpleName());
        this.error = errorDTO;
        this.status = status;
    }
}
