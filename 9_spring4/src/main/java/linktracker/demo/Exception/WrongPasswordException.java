package linktracker.demo.Exception;

import org.springframework.http.HttpStatus;

public class WrongPasswordException extends LinkException{
    public WrongPasswordException(String id) {
        super("Wrong password for link ID:" + id , HttpStatus.BAD_REQUEST);
    }
}
