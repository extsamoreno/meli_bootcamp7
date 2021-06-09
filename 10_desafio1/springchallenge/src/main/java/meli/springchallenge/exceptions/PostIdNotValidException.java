package meli.springchallenge.exceptions;

import org.springframework.http.HttpStatus;

public class PostIdNotValidException extends SocialMeliException{

    public PostIdNotValidException(int postId) {
        super("Post #" + postId + " is NOT valid ", HttpStatus.BAD_REQUEST);
    }
}
