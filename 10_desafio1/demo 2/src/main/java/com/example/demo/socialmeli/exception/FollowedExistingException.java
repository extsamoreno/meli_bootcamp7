package com.example.demo.socialmeli.exception;

import com.example.demo.socialmeli.service.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class FollowedExistingException extends Exception{
    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public FollowedExistingException (int userId) {
        this.errorDTO = new ErrorDTO();
        this.errorDTO.setMessage("Ya sigues al usuario " + userId);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
