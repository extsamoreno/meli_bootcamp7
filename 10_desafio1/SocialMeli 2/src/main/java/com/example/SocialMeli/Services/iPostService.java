package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.*;

import java.util.List;

public interface iPostService {
    public PostCountDTO getPromPostsCant(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException;
    public List<PostDTO> getPromPostsByUser(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException;
    public void makePost(NonPromoPostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException;
    public void makePost(PromoPostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException;
    public List<PostDTO> getFollowedPost(int userId, String order) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException;
}
