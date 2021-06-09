package com.example.desafio1.services;

import com.example.desafio1.dtos.*;
import com.example.desafio1.exceptions.product.InvalidDiscountException;
import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.exceptions.user.UserException;

public interface IProductService {
    String addNewPost(PostDTO postDTO) throws InvalidUserIdException;
    String addNewPromoPost(PostPromoDTO postPromoDTO) throws InvalidUserIdException, InvalidDiscountException;
    ResponseFollowedPostDTO getAllPostOfMyFollowed(int userId, String order) throws UserException;
    ResponsePromoCountDTO getPromoProductsCount(int userId) throws InvalidUserIdException;
    ResponsePromoListDTO getListOfPromoProducts(int userId) throws InvalidUserIdException;
}
