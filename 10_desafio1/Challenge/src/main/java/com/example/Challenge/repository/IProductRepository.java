package com.example.Challenge.repository;

import com.example.Challenge.model.Product;
import com.example.Challenge.model.User;

import java.util.HashMap;
import java.util.List;

public interface IProductRepository {
    String createPost(Product product);
    List<Product> getAllProducts(Integer userId);
}
