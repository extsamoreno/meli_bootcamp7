package com.desafio.SocialMeli.Repository.User;

import com.desafio.SocialMeli.Classes.User;

import java.util.List;

public interface IUserRepository {

    List<User> getAllUsers();

    User getUserById(int userId);

    void saveUser(User user);

}
