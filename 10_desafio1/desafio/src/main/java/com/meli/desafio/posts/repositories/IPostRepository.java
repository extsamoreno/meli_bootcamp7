package com.meli.desafio.posts.repositories;

import com.meli.desafio.posts.exceptions.PostErrorException;
import com.meli.desafio.posts.exceptions.PostNotExistException;
import com.meli.desafio.posts.models.Post;
import com.meli.desafio.posts.models.dto.PostDTO;

import java.util.List;

public interface IPostRepository {
    void save(Post post) throws PostErrorException;

    Post getById(Integer postId) throws PostNotExistException;

    List<Post> getAllByUserId(Integer userId);

    List<Post> getAllPromosByUserId(Integer userId);
}
