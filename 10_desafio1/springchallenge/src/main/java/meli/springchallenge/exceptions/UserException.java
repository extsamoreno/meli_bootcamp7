package meli.springchallenge.exceptions;

import lombok.Data;
import meli.springchallenge.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

@Data
public class UserException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }

}
