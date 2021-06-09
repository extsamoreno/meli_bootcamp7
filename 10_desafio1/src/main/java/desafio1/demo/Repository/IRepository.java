package desafio1.demo.Repository;

import desafio1.demo.Exception.DuplicatePostIdException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.Entity.Post;
import desafio1.demo.Model.Entity.User;

import java.util.HashMap;
import java.util.stream.Stream;

public interface IRepository {
    public User getUserById(int userId) throws UserNotFoundException;
    public Stream<User> getUserFollowersById(int userId) throws UserNotFoundException;
    public Stream<Post> getUserPromoPostsById(int userId) throws UserNotFoundException;
    void addNewPost(Post newPost) throws UserNotFoundException, DuplicatePostIdException;
}
