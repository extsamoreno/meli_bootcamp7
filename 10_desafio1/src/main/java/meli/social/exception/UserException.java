package meli.social.exception;

import lombok.Getter;
import meli.social.service.dto.UserErrorDTO;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends Exception{
    private UserErrorDTO error;
    private HttpStatus status;

    public UserException(String message, HttpStatus status){
        this.error = new UserErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;
    }
}