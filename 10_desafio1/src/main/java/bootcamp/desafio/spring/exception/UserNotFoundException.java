package bootcamp.desafio.spring.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{

    public UserNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }

}
