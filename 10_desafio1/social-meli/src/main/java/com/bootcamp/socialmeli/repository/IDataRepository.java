package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IDataRepository {

    User findUserById(Integer id);

    List<User> getAllUsers();

    List<User> getUserFollowers(Integer id);

    List<User> getUserFollowed(Integer id);

    Post findPostById(Integer id);

    List<Post> getAllPost();
}
