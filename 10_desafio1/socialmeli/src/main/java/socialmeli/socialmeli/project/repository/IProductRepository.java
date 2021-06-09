package socialmeli.socialmeli.project.repository;

import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.models.Post;

public interface IProductRepository {
    public void save (Post post) throws PostAlreadyExistsException;

}
