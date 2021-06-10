package com.example.demo.socialmeli.exception;

import com.example.demo.socialmeli.service.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class UserNotFoundException extends Exception{
    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public UserNotFoundException(int userId) {
        this.errorDTO = new ErrorDTO();
        this.errorDTO.setMessage("No se encontró el usuario con id: " + userId);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
