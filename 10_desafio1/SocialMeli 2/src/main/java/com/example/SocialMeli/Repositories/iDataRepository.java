package com.example.SocialMeli.Repositories;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.*;

import java.util.List;

public interface iDataRepository {

    public FollowDTO follow(int followerId, int followedId) throws UserNotFoundException;
    public List<PostDTO> getFollowedPost(int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException;
    public FollowCountDTO getFollowersCount(int user_id) throws UserNotFoundException;
    public FollowersDTO getFollowers(int user_id) throws UserNotFoundException;
    public FollowedDTO getFollowed(int user_id) throws UserNotFoundException;
    public void makePost(PostDTO post) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException;
    public List<User> getUsers();
}
