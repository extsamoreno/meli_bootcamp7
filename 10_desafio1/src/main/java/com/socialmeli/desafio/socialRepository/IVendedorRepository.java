package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.VendedorModel;

public interface IVendedorRepository {


    public void altaVendedor(String userName);

    public void listarVendedores();

    public VendedorModel getVendedorById(int id);
}
