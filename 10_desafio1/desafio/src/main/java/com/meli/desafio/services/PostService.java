package com.meli.desafio.services;

import com.meli.desafio.exceptions.PostErrorException;
import com.meli.desafio.exceptions.PostNotExistException;
import com.meli.desafio.models.Post;
import com.meli.desafio.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    @Autowired
    IPostRepository postRepository;

    @Override
    public Integer addNewPost(Post post) throws PostErrorException {
        postRepository.save(post);
        return post.getPostId();
    }

    @Override
    public Post getById(Integer postId) throws PostNotExistException {
        return postRepository.getById(postId);
    }
}
