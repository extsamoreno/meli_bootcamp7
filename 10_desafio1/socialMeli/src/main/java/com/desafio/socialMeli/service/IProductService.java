package com.desafio.socialMeli.service;

import com.desafio.socialMeli.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.exceptions.UserNotFoundException;
import com.desafio.socialMeli.repository.entities.Post;
import com.desafio.socialMeli.service.dto.UserFollowedPostsDTO;

public interface IProductService {
    String saveNewPost(Post post) throws UserNotFoundException;
    UserFollowedPostsDTO getFollowedPostsByUser(int userId) throws UserNotFoundException, RepositoryUnableException;

    UserFollowedPostsDTO getListOfFollowers(int userId);
}
