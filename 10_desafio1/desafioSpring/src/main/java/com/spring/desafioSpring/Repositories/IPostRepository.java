package com.spring.desafioSpring.Repositories;

import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Models.Post;

public interface IPostRepository {
    void insertPost(Post post) throws PostIdExistsException;
}
