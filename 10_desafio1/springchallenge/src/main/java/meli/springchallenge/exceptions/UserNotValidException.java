package meli.springchallenge.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotValidException extends SocialMeliException {

    public UserNotValidException(int userId) {
        super("UserID #" + userId + " is not valid ", HttpStatus.BAD_REQUEST);
    }
}
