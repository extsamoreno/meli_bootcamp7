package com.meli.desafio.repository;

import com.meli.desafio.exceptions.PostErrorException;
import com.meli.desafio.models.Post;

public interface IPostRepository {
    void save(Post post) throws PostErrorException;
}
