package desafio1.desafio1.exception;

import desafio1.desafio1.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{

    public UserNotFoundException(Integer userId){
        super(new ErrorDTO("User Not Found", "Id could not be found "+userId), HttpStatus.BAD_REQUEST);
    }
}
