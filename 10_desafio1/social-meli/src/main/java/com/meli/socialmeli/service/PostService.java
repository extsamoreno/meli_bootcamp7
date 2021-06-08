package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.NewPostDTO;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void addPost(NewPostDTO newPost) throws UserIdNotFoundException {
        if(iUserRepository.findUserById(newPost.getUserId()) == null) {
            throw new UserIdNotFoundException(newPost.getUserId());
        }

        iPostRepository.insertPost(PostMapper.toPost(newPost));
    }
}
