package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Services.DTOs.*;

import java.util.List;

public interface iProductService {
    public PostCountDTO getPromPostsCant(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException;
    public PostsDTO getPromPostsByUser(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException;
    public void makePost(NonPromoPostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException;
    public void makePost(PromoPostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException;
    public PostsDTO getFollowedPost(int userId, String order) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException;
}
