package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.Exception.RegisteredFollowerException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.SellerIdNotFoundException;

public interface IInitRepository {

    public  void altaUsuarios();
    public void altaVendedores();
    public void follow() throws UserIdNotFoundException, SellerIdNotFoundException, RegisteredFollowerException;
    //public void createPost();
}
