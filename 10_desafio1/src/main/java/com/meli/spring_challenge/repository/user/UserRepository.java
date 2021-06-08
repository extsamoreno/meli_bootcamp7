package com.meli.spring_challenge.repository.user;

import com.meli.spring_challenge.model.User;

import java.util.List;

public interface UserRepository {
    User getUserByID(int userID);
    User updateUser(User user);
    boolean removeUser(User user);
    List<User> getAllUsers();
}
