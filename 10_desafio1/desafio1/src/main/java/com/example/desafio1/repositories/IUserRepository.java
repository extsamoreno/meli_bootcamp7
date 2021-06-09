package com.example.desafio1.repositories;

import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.models.User;

public interface IUserRepository {

    String createDB();
    User getUserById(int userId) throws InvalidUserIdException;
}
