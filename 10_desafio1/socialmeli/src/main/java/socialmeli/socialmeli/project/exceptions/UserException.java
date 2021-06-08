package socialmeli.socialmeli.project.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import socialmeli.socialmeli.project.services.Dto.ErrorDto;


@Getter
public class UserException extends Exception{
    private ErrorDto error;
    private HttpStatus status;

    public UserException (String message, HttpStatus status){
        this.error = new ErrorDto();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
