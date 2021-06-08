package com.example.desafio1.repository;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;

public interface iUserRepository {

    User saveUser(User user);
    User findUserById(Integer id);
    void loadUsers();

}
