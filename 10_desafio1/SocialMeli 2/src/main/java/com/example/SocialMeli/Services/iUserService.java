package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.*;
import com.example.SocialMeli.Services.Helpers.Ordenable;
import jdk.javadoc.doclet.Doclet;

import java.util.List;

public  interface iUserService{


    public FollowDTO follow(int followerId, int followedId) throws UserNotFoundException;
    public FollowDTO unfollow(int followerId, int followedId) throws UserNotFoundException;
    public FollowCountDTO getFollowersCount(int userId) throws UserNotFoundException;
    public FollowersDTO getFollowers(int user_id, String order) throws UserNotFoundException;
    public FollowedDTO getFollowed(int user_id, String order) throws UserNotFoundException;

}
