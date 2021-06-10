package com.example.Challenge.service;

import com.example.Challenge.dto.ProductCountPromoDTO;
import com.example.Challenge.dto.ProductListPromoDTO;
import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.exception.ProductException;
import com.example.Challenge.exception.ProgramException;
import com.example.Challenge.model.Product;

import java.util.List;

public interface IProductService {
    String newPost(Product product) throws ProgramException;
    List<Product> getAllProduct(Integer userId) throws ProgramException;
    ProductResponseDTO getPostById(Integer idUser, String order) throws ProgramException;
    String newPromoPost(Product product) throws ProgramException;
    ProductCountPromoDTO countProductPromo(Integer userId) throws ProgramException;
    ProductListPromoDTO listProductPromo(Integer userId) throws ProgramException;
}
