package com.desafiospring.socialMeli.service;

import com.desafiospring.socialMeli.dto.request.NewPostDTO;
import com.desafiospring.socialMeli.dto.request.NewPromoPostDTO;
import com.desafiospring.socialMeli.dto.response.FollowedPostDTO;
import com.desafiospring.socialMeli.dto.response.PromoPostCountDTO;
import com.desafiospring.socialMeli.dto.response.PromoPostListDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;

public interface IPostService {

    void newPost(NewPostDTO post) throws UserNotFoundException, PostIdAlreadyExistException;

    FollowedPostDTO getFollowedRecentPosts(int userId, String order) throws UserNotFoundException;

    void newPromoPost(NewPromoPostDTO promoPost) throws UserNotFoundException, PostIdAlreadyExistException;

    PromoPostCountDTO getPromoPostCount(int userId) throws UserNotFoundException;

    PromoPostListDTO getPromoPostsList(int userId) throws UserNotFoundException;
}
