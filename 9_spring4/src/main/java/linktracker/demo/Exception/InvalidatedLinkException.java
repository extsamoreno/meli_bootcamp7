package linktracker.demo.Exception;

import org.springframework.http.HttpStatus;

public class InvalidatedLinkException extends LinkException{
    public InvalidatedLinkException(String id) {
        super("Link ID:" + id + " has been invalidated", HttpStatus.BAD_REQUEST);
    }
}
