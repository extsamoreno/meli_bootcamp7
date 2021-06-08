package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {

    User findById(Integer id);

    List<User> getAllUsers();

    List<User> getUserFollowers(Integer id);

    List<User> getUserFollowed(Integer id);
}
