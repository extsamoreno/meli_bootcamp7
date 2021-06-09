package com.meli.desafio.posts.services;

import com.meli.desafio.posts.exceptions.PostErrorException;
import com.meli.desafio.posts.exceptions.PostNotExistException;
import com.meli.desafio.posts.models.Post;
import com.meli.desafio.posts.models.dto.PostDTO;
import com.meli.desafio.posts.models.dto.ResponseListPostsDto;
import com.meli.desafio.users.exceptions.UserNotFoundException;

import java.util.List;

public interface IPostService {
    Integer addNewPost(PostDTO postDTO) throws PostErrorException;

    PostDTO getById(Integer postId) throws PostNotExistException;

    ResponseListPostsDto getPostList(Integer userId) throws UserNotFoundException;

    List<ResponseListPostsDto> getPostListForUsersFollowed(Integer userId, String order) throws UserNotFoundException;
}
