package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Repositories.iDataRepository;
import com.example.SocialMeli.Services.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements iPostService{

    @Autowired
    iDataRepository iDataRepository;

    @Override
    public void makePost(PostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException {
        iDataRepository.makePost(postDTO);
    }

    @Override
    public List<PostDTO> getFollowedPost(int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException {
        return iDataRepository.getFollowedPost(userId);
    }

}
