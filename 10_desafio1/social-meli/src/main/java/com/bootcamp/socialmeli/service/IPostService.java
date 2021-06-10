package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.response.ListOfFollowedPostsDTOres;
import com.bootcamp.socialmeli.DTO.request.PostDTOreq;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;

import java.util.Optional;

public interface IPostService {

    void newPost(PostDTOreq post) throws UserIdNotFoundException, PostAlreadyRegisteredException;

    ListOfFollowedPostsDTOres getFollowedPost(Integer userId, Optional<String> order) throws UserIdNotFoundException;
}
