package com.example.Challenge.service;

import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.model.Product;

import java.util.HashMap;
import java.util.List;

public interface IProductService {
    String newPost(Product product);
    List<Product> getAllProduct(Integer userId);
    ProductResponseDTO getPostById(Integer idUser, String order);
}
