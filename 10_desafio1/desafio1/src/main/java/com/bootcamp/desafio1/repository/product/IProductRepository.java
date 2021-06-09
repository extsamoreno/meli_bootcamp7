package com.bootcamp.desafio1.repository.product;

import com.bootcamp.desafio1.exception.ProductAlreadyExistsException;
import com.bootcamp.desafio1.exception.ProductNotFoundException;
import com.bootcamp.desafio1.model.Product;

public interface IProductRepository {

    Product getProductById(int productId) throws ProductNotFoundException;

    void addProductInDB(Product product) throws ProductAlreadyExistsException;

}
