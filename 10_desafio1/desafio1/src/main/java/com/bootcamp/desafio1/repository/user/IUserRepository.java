package com.bootcamp.desafio1.repository.user;

import com.bootcamp.desafio1.exception.UserNotFoundException;
import com.bootcamp.desafio1.model.User;

public interface IUserRepository {

    User getUserById(int id) throws UserNotFoundException;

    void updateUserInDB(User user);

}
