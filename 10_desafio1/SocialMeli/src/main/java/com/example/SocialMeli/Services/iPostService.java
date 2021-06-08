package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.*;

import java.util.List;

public interface iPostService {
    public void makePost(PostDTO postDTO) throws UserNotFoundException;
}
