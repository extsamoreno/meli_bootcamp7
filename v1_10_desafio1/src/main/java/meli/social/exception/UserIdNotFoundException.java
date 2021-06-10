package meli.social.exception;

import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends UserException {
    public UserIdNotFoundException(Integer userId) {
        super("El id: "+ userId +" no corresponde a ningun usuario registrado", HttpStatus.BAD_REQUEST);
    }
}
