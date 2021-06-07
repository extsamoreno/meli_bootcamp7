package linktracker.demo.Exception;

import org.springframework.http.HttpStatus;

public class InvalidIdException extends LinkException{
    public InvalidIdException(String id) {
        super("Invalid link ID: " + id, HttpStatus.BAD_REQUEST);
    }
}
