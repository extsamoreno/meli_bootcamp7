package com.Desafio1.SocialMeli.Repositories;

import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Models.Post;

public interface IPostRepository {
    void createPost(Post post)throws DuplicateIdException;
}
