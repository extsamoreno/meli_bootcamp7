package com.example.Challenge.service;

import com.example.Challenge.dto.ProductCountPromoDTO;
import com.example.Challenge.dto.ProductListPromoDTO;
import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.exception.UserException;
import com.example.Challenge.model.Product;

import java.util.List;

public interface IProductService {
    String newPost(Product product) throws UserException;
    List<Product> getAllProduct(Integer userId) throws UserException;
    ProductResponseDTO getPostById(Integer idUser, String order) throws UserException;
    String newPromoPost(Product product) throws UserException;
    ProductCountPromoDTO countProductPromo(Integer userId) throws UserException;
    ProductListPromoDTO listProductPromo(Integer userId) throws UserException;
}
