package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Repositories.iDataRepository;
import com.example.SocialMeli.Services.DTOs.FollowCountDTO;
import com.example.SocialMeli.Services.DTOs.FollowDTO;
import com.example.SocialMeli.Services.DTOs.FollowedDTO;
import com.example.SocialMeli.Services.DTOs.FollowersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements iUserService{

    @Autowired
    iDataRepository iDataRepository;

    @Override
    public FollowDTO follow(int followerId, int followedId) throws UserNotFoundException {
        return iDataRepository.follow(followerId, followedId);
    }

    @Override
    public FollowDTO unfollow(int followerId, int followedId) throws UserNotFoundException {
        return iDataRepository.unfollow(followerId, followedId);
    }

    public FollowCountDTO getFollowersCount(int userId) throws UserNotFoundException{
        return iDataRepository.getFollowersCount(userId);
    }

    @Override
    public FollowersDTO getFollowers(int userId) throws UserNotFoundException {
        return iDataRepository.getFollowers(userId);
    }

    @Override
    public FollowedDTO getFollowed(int userId) throws UserNotFoundException{
        return iDataRepository.getFollowed(userId);
    }


    public List<User> getdb(){
        return iDataRepository.getUsers();
    }
}
