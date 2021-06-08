package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.PostIdInUseException;
import com.example.SocialMeli.Exceptions.ProductIdInUseException;
import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Repositories.iDataRepository;
import com.example.SocialMeli.Services.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements iPostService{

    @Autowired
    iDataRepository iDataRepository;

    @Override
    public void makePost(PostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException {
        iDataRepository.makePost(postDTO);
    }

}
