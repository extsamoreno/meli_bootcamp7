package meli.springchallenge.exceptions;

import org.springframework.http.HttpStatus;

public class RelationNonExistentException extends SocialMeliException{

    public RelationNonExistentException(int follower, int followed) {
        super("Relation between user #" + follower + "and user #" + followed +"  does not exist ", HttpStatus.BAD_REQUEST);
    }
}
