package socialmeli.socialmeli.project.exceptions.ProductExceptions;

import org.springframework.http.HttpStatus;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.models.Product;

public class PostAlreadyExistsException extends ProductException{

    public PostAlreadyExistsException(Post post){
        super("The postId: "+post.getIdPost()+" is already posted", HttpStatus.BAD_REQUEST);
    }
}
