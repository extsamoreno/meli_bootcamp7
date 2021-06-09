package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.service.dto.ProductDTO;
import com.example.MeliSocialApi.project.service.dto.ProductUserDTOResponse;

public interface IProductService {
    void createProduct(ProductDTO productParam) throws UserNotFoundException;
    ProductUserDTOResponse getProductFromUser(Integer userId, int weeks) throws UserNotFoundException;
}
