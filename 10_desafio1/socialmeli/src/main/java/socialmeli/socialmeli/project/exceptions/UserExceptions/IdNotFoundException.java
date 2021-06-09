package socialmeli.socialmeli.project.exceptions.UserExceptions;

import org.springframework.http.HttpStatus;

public class IdNotFoundException extends UserException {

    public IdNotFoundException(String id) {
        super("ID: " + id + " is not valid", HttpStatus.BAD_REQUEST);
    }

}
