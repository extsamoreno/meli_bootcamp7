package com.example.demo.socialmeli.exception;

import com.example.demo.socialmeli.service.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class FollowedNotExistingException extends Exception{
    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public FollowedNotExistingException (int userId) {
        this.errorDTO = new ErrorDTO();
        this.errorDTO.setMessage("Aún no has seguido al usuario " + userId);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
