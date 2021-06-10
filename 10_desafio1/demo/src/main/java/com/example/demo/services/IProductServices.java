package com.example.demo.services;

import com.example.demo.DTO.*;
import com.example.demo.exception.GenericException;
import com.example.demo.exception.OrderErrorException;
import com.example.demo.exception.UserNotFoundException;

public interface IProductServices {

    void newPost(PostDTO post) throws UserNotFoundException;

    PostListDTO getPostList(Integer userId, String order) throws OrderErrorException;

    void newPromoPost(PromoPostDTO promoPost) throws GenericException;

    PromoPostCountDTO countPromo(Integer userId) throws GenericException;

    PromoPostListDTO getPromoPostList(Integer userId, String order) throws GenericException;
}
