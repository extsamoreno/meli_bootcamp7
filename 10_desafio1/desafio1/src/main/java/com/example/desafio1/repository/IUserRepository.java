package com.example.desafio1.repository;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;

import java.util.ArrayList;

public interface IUserRepository {
    ArrayList<User> getUsersList();
    User getUserById(int userId) throws UserNotFoundException;



}
