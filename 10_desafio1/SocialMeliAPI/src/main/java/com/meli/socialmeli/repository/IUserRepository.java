package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.User;

public interface IUserRepository {
    public User getUserById(int userId);
    public void saveUser(User user);
}
