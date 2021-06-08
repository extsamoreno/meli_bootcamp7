package com.example.desafio1.repository;


import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.model.Product;

public interface IProductRepository {

    void createProduct(Product product);
    Product getProductById(int productId) throws ProductNotFoundException;
}
