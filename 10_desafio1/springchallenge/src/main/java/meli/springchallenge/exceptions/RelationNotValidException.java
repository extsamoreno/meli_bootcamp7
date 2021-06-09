package meli.springchallenge.exceptions;

import org.springframework.http.HttpStatus;

public class RelationNotValidException extends SocialMeliException {

    public RelationNotValidException(int follower, int following) {
        super("Relation between user #" + follower + "and user #" +following +" is not valid, or is already exiting ", HttpStatus.BAD_REQUEST);
    }
}
