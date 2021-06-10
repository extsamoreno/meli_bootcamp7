package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.response.CountPromoProductsDTO;
import com.bootcamp.socialmeli.DTO.response.ListOfPostsDTOres;
import com.bootcamp.socialmeli.DTO.request.PostDTOreq;
import com.bootcamp.socialmeli.DTO.response.ListOfPostsWithUsernameDTOres;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;

import java.util.Optional;

public interface IPostService {

    void newPost(PostDTOreq post) throws UserIdNotFoundException, PostAlreadyRegisteredException;

    ListOfPostsDTOres getFollowedPost(Integer userId, Optional<String> order) throws UserIdNotFoundException;

    CountPromoProductsDTO getCountPromoProducts(Integer userId) throws UserIdNotFoundException;

    ListOfPostsWithUsernameDTOres getListPromoProducts(Integer userId) throws UserIdNotFoundException;
}
