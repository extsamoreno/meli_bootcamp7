package com.example.desafio1.services;

import com.example.desafio1.dtos.*;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.exceptions.UserException;

public interface IProductService {
    String addNewPost(PostDTO postDTO) throws InvalidUserIdException;
    String addNewPromoPost(PostPromoDTO postPromoDTO) throws InvalidUserIdException;
    ResponseFollowedPostDTO getAllPostOfMyFollowed(int userId, String order) throws UserException;
    ResponsePromoCountDTO getPromoProductsCount(int userId) throws InvalidUserIdException;
    ResponsePromoListDTO getListOfPromoProducts(int userId) throws InvalidUserIdException;
}
