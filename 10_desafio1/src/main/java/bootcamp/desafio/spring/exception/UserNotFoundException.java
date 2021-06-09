package bootcamp.desafio.spring.exception;

import org.springframework.http.HttpStatus;


public class UserNotFoundException extends UserException{

    public UserNotFoundException(Long UserId) {
        super("El usuario con id: "+UserId+" no se encuentra registrado", HttpStatus.BAD_REQUEST);
    }

}
