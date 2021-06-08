package desafio1.demo.Exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{
    public UserNotFoundException(int id) {
        super("User with ID:"+id+" not found", HttpStatus.NOT_FOUND);
    }
}
