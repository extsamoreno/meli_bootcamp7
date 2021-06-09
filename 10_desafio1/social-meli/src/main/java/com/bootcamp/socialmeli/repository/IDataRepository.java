package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.PostRequestDTO;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
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

    void newPost(Post post) throws UserIdNotFoundException, PostAlreadyRegisteredException;

    Post findPostById(Integer id);
}
