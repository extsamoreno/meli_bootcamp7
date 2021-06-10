package com.example.challenge.Services;

import com.example.challenge.Exceptions.InvalidOrderException;
import com.example.challenge.Exceptions.NotPromoPostException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Services.DTOs.*;

public interface IProductService {

    String addNewPost(PostDTO postDTO) throws UserNotFoundException;

    String addNewPromoPost(PostPromotionDTO postDTO) throws UserNotFoundException, InvalidOrderException, NotPromoPostException;

    ResponseFollowedPostDTO getMyFollowedPostList(int userId, String order) throws UserNotFoundException, InvalidOrderException;

    PromoCountDTO getCountPromo(int userId) throws UserNotFoundException;

    ResponsePromotionListDTO getPromotionsPost(int userId) throws UserNotFoundException;
}