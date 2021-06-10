package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.Exception.SeguidorYaRegistradoException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.VendedorIdNotFoundException;

import java.text.ParseException;

public interface IInitRepository {

    public  void altaUsuarios();
    public void altaVendedores();
    public void follow() throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorYaRegistradoException;
    //public void createPost();
}
