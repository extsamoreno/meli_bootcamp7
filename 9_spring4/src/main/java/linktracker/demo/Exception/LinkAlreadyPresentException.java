package linktracker.demo.Exception;

import org.springframework.http.HttpStatus;

public class LinkAlreadyPresentException extends LinkException{
    public LinkAlreadyPresentException(String link) {
        super("Link "+link+" is already saved", HttpStatus.BAD_REQUEST);
    }
}
