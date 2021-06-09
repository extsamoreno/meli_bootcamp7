package com.bootcamp.desafio1.repository.post;


import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.PostNotFoundException;
import com.bootcamp.desafio1.model.Post;

public interface IPostRepository {

    boolean postIdExists(int postId);

    Post getPostById(int postId) throws PostNotFoundException;

    void addPostInDB(Post post) throws PostAlreadyExistsException;

}
