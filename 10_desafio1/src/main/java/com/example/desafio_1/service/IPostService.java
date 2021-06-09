package com.example.desafio_1.service;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.models.Post;
import com.example.desafio_1.service.dto.FollowedPostDTO;
import com.example.desafio_1.service.dto.PostDTO;

public interface IPostService {
    void createPostByDTO(PostDTO postDTO) throws UserExceptionNotFound, UserExceptionWrongType, ProductExceptionNotFound, NumberNotGreaterThanZero, EmptyStringException, PostExceptionNotValid, ProductExceptionNotValid, PostExceptionNotExists, PostExceptionAlreadyExists;
    void createPost(Post post);

    FollowedPostDTO getFollowedUsersPostsByUserId(int userId) throws UserExceptionNotFound, UserExceptionWrongType;
}
