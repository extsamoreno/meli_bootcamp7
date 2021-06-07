package linktracker.demo.Exception;

import org.springframework.http.HttpStatus;

public class InvalidURLException extends LinkException{
    public InvalidURLException(String url) {
        super("The URL: " + url + " is not valid", HttpStatus.BAD_REQUEST);
    }
}
