package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.PostIdInUseException;
import com.example.SocialMeli.Exceptions.ProductIdInUseException;
import com.example.SocialMeli.Exceptions.ProductNotFoundException;
import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Repositories.iUserRepository;
import com.example.SocialMeli.Services.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements iPostService{

    @Autowired
    iUserRepository iUserRepository;

    @Override
    public void makePost(PostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException {
        iUserRepository.makePost(postDTO);
    }

}
