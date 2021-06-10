package com.example.desafio1.repositories;

import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.models.User;

import java.util.HashMap;

public interface IUserRepository {

    String createDB();
    boolean addUser(User user);
    HashMap<Integer, User> getUsers();
    User getUserById(int userId) throws InvalidUserIdException;
}
