package com.example.desafio1.repository;


import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.model.Product;

import java.util.HashMap;

public interface IProductRepository {

    void createProduct(Product product);
    Product getProductById(int productId) throws ProductNotFoundException;
    boolean isUsedId(int productId);
    int validId();
    HashMap<Integer, Product> getProductCatalog();
    boolean isProductInCatalog(Product product);
    int getProductId(Product product);
}
