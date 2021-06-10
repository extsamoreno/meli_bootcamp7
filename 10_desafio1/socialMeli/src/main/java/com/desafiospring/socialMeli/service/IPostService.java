package com.desafiospring.socialMeli.service;

import com.desafiospring.socialMeli.dto.PostDTO;
import com.desafiospring.socialMeli.dto.FollowedPostDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;

public interface IPostService {

    void newPost(PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException;

    FollowedPostDTO getFollowedPosts(int userId, String order) throws UserNotFoundException;

}
