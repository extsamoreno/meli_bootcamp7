package com.example.Challenge.repository;

import com.example.Challenge.model.Product;

import java.util.HashMap;
import java.util.List;

public interface IProductRepository {
    String createPost(Product product);
    List<Product> getAllProducts();
}
