package com.example.Challenge.service;

import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.exception.ProductException;
import com.example.Challenge.exception.UserException;
import com.example.Challenge.model.Product;

import java.util.HashMap;
import java.util.List;

public interface IProductService {
    String newPost(Product product) throws ProductException;
    List<Product> getAllProduct(Integer userId) throws UserException;
    ProductResponseDTO getPostById(Integer idUser, String order) throws UserException;
}
