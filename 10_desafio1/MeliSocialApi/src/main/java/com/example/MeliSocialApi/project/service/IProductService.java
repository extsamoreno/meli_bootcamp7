package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.exception.ProductNoValidDateException;
import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.service.dto.ProductDTO;
import com.example.MeliSocialApi.project.service.dto.ProductPromoCountDTOResponse;
import com.example.MeliSocialApi.project.service.dto.ProductUserDTOResponse;

import java.util.Optional;

public interface IProductService {
    void createProduct(ProductDTO productParam) throws UserNotFoundException, ProductNoValidDateException;
    ProductUserDTOResponse getProductFromUser(Integer userId, int weeks, Optional<String> order) throws UserNotFoundException;
    ProductPromoCountDTOResponse getCountProductsPromoByUser(Integer userId) throws UserNotFoundException;
    ProductUserDTOResponse getProductPromoFromUser(Integer userId) throws UserNotFoundException;
}
