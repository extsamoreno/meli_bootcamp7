package com.desafio.socialMeli.model.service;

import com.desafio.socialMeli.model.dao.models.Post;
import com.desafio.socialMeli.model.dto.PostDTOCount;
import com.desafio.socialMeli.model.dto.PostDTOList;
import com.desafio.socialMeli.model.dto.UserFollowedPostsDTO;
import com.desafio.socialMeli.model.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.model.exceptions.UserNotFoundException;

public interface IProductService {
    String saveNewPost(Post post) throws UserNotFoundException;
    UserFollowedPostsDTO getFollowedPostsByUser(int userId) throws UserNotFoundException, RepositoryUnableException;
    UserFollowedPostsDTO getFollowedPostsByUser(int userid, String order) throws UserNotFoundException, RepositoryUnableException;
    PostDTOCount getNumberOfPostsWithPromo(int userid);
    PostDTOList getPromoPostsByUser(int userid);
    //UserFollowedPostsDTO getListOfFollowers(int userId);
}
