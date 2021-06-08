package com.example.Challenge.repository;

import com.example.Challenge.model.User;

public interface IUserRepository {

    User getUserById(Integer id);
    void saveChanges(User user);

}
