package com.meli.desafio.services;

import com.meli.desafio.exceptions.PostErrorException;
import com.meli.desafio.models.Post;

public interface IPostService {
    Integer addNewPost(Post post) throws PostErrorException;
}
