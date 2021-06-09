package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.FollowedPostsDTO;
import com.meli.socialmeli.dto.NewPostDTO;
import com.meli.socialmeli.exception.UserIdNotFoundException;

public interface IPostService {
    void addPost(NewPostDTO newPost) throws UserIdNotFoundException;
    FollowedPostsDTO getFollowedPosts(Integer userId, String order) throws UserIdNotFoundException;
}
