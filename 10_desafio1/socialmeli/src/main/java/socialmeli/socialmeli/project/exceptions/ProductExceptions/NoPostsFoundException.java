package socialmeli.socialmeli.project.exceptions.ProductExceptions;

import org.springframework.http.HttpStatus;
import socialmeli.socialmeli.project.models.Post;

public class NoPostsFoundException  extends ProductException {
    public NoPostsFoundException (Integer userId){
        super("No posts found for userId: "+ userId, HttpStatus.BAD_REQUEST);
    }

}
