package com.example.desafio1.services;

import com.example.desafio1.dtos.*;
import com.example.desafio1.exceptions.product.ProductException;
import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.exceptions.user.UserException;

public interface IProductService {
    String addNewPost(PostDTO postDTO) throws InvalidUserIdException, ProductException;
    String addNewPromoPost(PostPromoDTO postPromoDTO) throws InvalidUserIdException, ProductException;
    ResponseFollowedPostDTO getAllPostOfMyFollowed(int userId, String order) throws UserException;
    ResponsePromoCountDTO getPromoProductsCount(int userId) throws InvalidUserIdException;
    ResponsePromoListDTO getListOfPromoProducts(int userId) throws InvalidUserIdException;
}
