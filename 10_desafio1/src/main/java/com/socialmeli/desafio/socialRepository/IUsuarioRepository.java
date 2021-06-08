package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.UsuarioModel;

public interface IUsuarioRepository {

     void altaUsuario(String userName);

   void listarUsuarios();

    public UsuarioModel getUsuarioById(int id);


}
