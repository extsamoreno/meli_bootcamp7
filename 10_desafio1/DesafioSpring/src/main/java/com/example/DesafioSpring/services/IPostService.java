package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.*;
import com.example.DesafioSpring.exceptions.*;

public interface IPostService {
    public PostCounterDTO postWithPromo(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException;
    public PostsConstructorDTO sellerPromoList(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException;
    public void newPost(NoPromoDTO postDTO) throws ProductTakenException, PostTakenException, UserNotFoundException, PostNotFoundException;
    public void newPost(PromoPostDTO postDTO) throws ProductTakenException, PostTakenException, UserNotFoundException, PostNotFoundException;
    public PostsConstructorDTO getFollowedByPost(int userId, String order) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException;
}

