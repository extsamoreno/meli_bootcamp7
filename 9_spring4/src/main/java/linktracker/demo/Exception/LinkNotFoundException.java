package linktracker.demo.Exception;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends LinkException{
    public LinkNotFoundException(String id) {
        super("Link Id:" + id + " not found", HttpStatus.NOT_FOUND);
    }
}
