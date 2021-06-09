package com.spring.desafioSpring.Repositories;

import com.spring.desafioSpring.DTOs.CountPromosDTO;
import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Models.Post;

import java.util.List;

public interface IPostRepository {
    void insertPost(Post post) throws PostIdExistsException;
    List<Post> getPostsByUser(int userId);
    int getPromosCountByUser(int userId);
    List<Post> getPromosByUser(int userId);

}
