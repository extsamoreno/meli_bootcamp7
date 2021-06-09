package com.meli.socialmeli.services;

import com.meli.socialmeli.dto.UserPostListODT;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;
import com.meli.socialmeli.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{
    @Autowired
    IPostRepository iPostRepository;

    @Override
    public UserMeli newPost(Post post) {
        return iPostRepository.newPostAdd(post);
    }

    @Override
    public UserPostListODT getListPosts(int userId) {
        return null;
    }

}
