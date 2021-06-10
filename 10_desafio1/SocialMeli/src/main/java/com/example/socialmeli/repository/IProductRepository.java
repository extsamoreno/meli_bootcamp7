package com.example.socialmeli.repository;

import com.example.socialmeli.model.Product;

import java.util.List;

public interface IProductRepository {
    Product addProduct(Product obj);

    List<Product> getProducts();
}
