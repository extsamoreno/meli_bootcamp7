package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.SellerModel;

public interface ISellerRepository {


     void newSeller(String userName);

     void listSeller();

     SellerModel getVendedorById(int id);
}
