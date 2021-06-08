package desafio1.demo.Exception;

import org.springframework.http.HttpStatus;

public class UserCantFollowHimselfException extends ApiException {
    public UserCantFollowHimselfException(int id) {
        super("User " + id + " can't follow himself", HttpStatus.BAD_REQUEST);
    }
}
