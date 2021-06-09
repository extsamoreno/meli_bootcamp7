package com.example.challenge.Services;

import com.example.challenge.Exceptions.InvalidOrderException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Services.DTOs.PostDTO;
import com.example.challenge.Services.DTOs.PostPromotionDTO;
import com.example.challenge.Services.DTOs.ResponseFollowedPostDTO;

public interface IProductService {

    String addNewPost(PostDTO postDTO) throws UserNotFoundException;

    String addNewPromoPost(PostPromotionDTO postDTO) throws UserNotFoundException, InvalidOrderException;
    ResponseFollowedPostDTO getMyFollowedPostList(int userId, String order) throws UserNotFoundException, InvalidOrderException;
}