package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IDataRepository {

    User findUserById(Integer id) throws UserIdNotFoundException;

    User findUserByIdWithoutException(Integer id);

    List<User> getAllUsers();

    List<User> getUserFollowers(Integer id) throws UserIdNotFoundException;

    List<User> getUserFollowed(Integer id) throws UserIdNotFoundException;

    Post findPostById(Integer id);

    List<Post> getAllPost();
}
