package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.repository.IUserRepository;
import com.example.desafiospring.socialmeli.service.DTO.PostDTO;
import com.example.desafiospring.socialmeli.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException {
        userRepository.insertPost(
                PostMapper.getPost(post)
        );
    }

}
