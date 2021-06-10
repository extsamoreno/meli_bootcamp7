package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.UsuarioModel;

public interface IUserRepository {

    void altaUsuario(String userName);

   void listarUsuarios();

   UsuarioModel getUsuarioById(int id);


}
