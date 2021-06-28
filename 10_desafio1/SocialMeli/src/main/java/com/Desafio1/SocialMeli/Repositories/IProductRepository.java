package com.Desafio1.SocialMeli.Repositories;

import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Models.Product;

public interface IProductRepository{
    void addProduct(Product product)throws DuplicateIdException;
}
