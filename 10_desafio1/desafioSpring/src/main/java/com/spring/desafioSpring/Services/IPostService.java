package com.spring.desafioSpring.Services;

import com.spring.desafioSpring.DTOs.CountPromosDTO;
import com.spring.desafioSpring.DTOs.ListPromosDTO;
import com.spring.desafioSpring.DTOs.PostDTO;
import com.spring.desafioSpring.DTOs.PostsSellersFollowDTO;
import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Exceptions.PropertyNotFoundException;
import com.spring.desafioSpring.Exceptions.UserNotFoundException;

public interface IPostService {
    void insertPost(PostDTO post) throws PostIdExistsException;
    PostsSellersFollowDTO getPostsSellersFollow(int userId, String order) throws UserNotFoundException, PropertyNotFoundException;
    CountPromosDTO countPromosByUser(int userId) throws UserNotFoundException;
    ListPromosDTO getPromosByUser(int userId) throws UserNotFoundException;
}
