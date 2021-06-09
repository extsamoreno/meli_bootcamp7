package desafio1.desafio1.exception;

import desafio1.desafio1.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ValidateUserException extends UserException{

    public ValidateUserException(Integer userId){
        super(new ErrorDTO("User Not Found", "There is no user with id: "+userId), HttpStatus.BAD_REQUEST);
    }
}
