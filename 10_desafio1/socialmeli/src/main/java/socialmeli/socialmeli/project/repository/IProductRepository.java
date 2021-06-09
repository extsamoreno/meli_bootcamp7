package socialmeli.socialmeli.project.repository;

import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.Post;

import java.util.ArrayList;

public interface IProductRepository {
    public void save (Post post) throws PostAlreadyExistsException;

    boolean alreadyExists(Post post);

    ArrayList<Post> getArrayPostById(Integer userId) throws NoPostsFoundException;
}
