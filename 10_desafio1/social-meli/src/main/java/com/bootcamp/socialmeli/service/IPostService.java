package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.ListFollowedPostDTO;
import com.bootcamp.socialmeli.DTO.PostRequestDTO;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;

public interface IPostService {

    void newPost(PostRequestDTO post) throws UserIdNotFoundException, PostAlreadyRegisteredException;

    ListFollowedPostDTO getFollowedPost(Integer userId) throws UserIdNotFoundException;
}
