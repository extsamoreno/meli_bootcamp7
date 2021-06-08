package desafio1.demo.Exception;

import org.springframework.http.HttpStatus;

public class DuplicatePostIDException extends ApiException{
    public DuplicatePostIDException(int id_post) {
        super("Post ID:"+id_post+" already present for this user", HttpStatus.BAD_REQUEST);
    }
}
