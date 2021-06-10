package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.UserModel;

public interface IUserRepository {

    void newUser(String userName);

   void listUsers();

   UserModel getUsuarioById(int id);


}
