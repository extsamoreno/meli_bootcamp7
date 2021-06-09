package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.PostDTO;
import com.example.DesafioSpring.exceptions.*;

import java.util.List;

public interface IPostService {
    public void newPost(PostDTO postDTO) throws ProductTakenException, PostTakenException, UserNotFoundException, PostNotFoundException;
    public List<PostDTO> getFollowedPost(int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException;
}

