package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.*;

import java.util.List;

public interface iPostService {
    public void makePost(PostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException;
    public List<PostDTO> getFollowedPost(int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException;
}
