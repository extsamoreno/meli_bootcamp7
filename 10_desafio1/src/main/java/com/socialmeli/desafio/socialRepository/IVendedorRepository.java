package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.VendedorModel;

public interface IVendedorRepository {


     void altaVendedor(String userName);

     void listarVendedores();

     VendedorModel getVendedorById(int id);
}
