package com.Desafio1.SocialMeli.Services;

import com.Desafio1.SocialMeli.DTOS.FollowedPostListDTO;
import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Models.Post;

public interface IProductService {
    void createNewPost(Post post) throws DuplicateIdException, UserNotFoundException;
    FollowedPostListDTO getFollowedPostListByUserId (int userId, String sortBy) throws UserNotFoundException;
}
