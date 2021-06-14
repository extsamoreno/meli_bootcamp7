package com.desafio.socialMeli.model.service;

import com.desafio.socialMeli.model.dao.models.Post;
import com.desafio.socialMeli.model.dto.UserFollowedPostsDTO;
import com.desafio.socialMeli.model.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.model.exceptions.UserNotFoundException;

public interface IProductService {
    String saveNewPost(Post post) throws UserNotFoundException;
    UserFollowedPostsDTO getFollowedPostsByUser(int userId) throws UserNotFoundException, RepositoryUnableException;
    UserFollowedPostsDTO getListOfFollowers(int userId);
}
