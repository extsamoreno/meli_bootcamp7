package com.example.Challenge.repository;

import com.example.Challenge.model.Product;
import com.example.Challenge.model.User;

import java.util.HashMap;
import java.util.List;

public interface IProductRepository {
    //Create product/post
    String createPost(Product product);
    //Get all products
    List<Product> getAllProductsFollowed(Integer userId);
    List<Product> getAllSellerProducts(Integer userId);
    List<Product> getAllProducts();
    List<Product> getAllSellerPromoProducts(Integer userId);
    String createPromoPost(Product product);
}
