package com.example.challenge.Services.Mappers;

import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.FollowerCountDTO;
import com.example.challenge.Services.DTOs.FollowersDTO;
import com.example.challenge.Services.DTOs.GetUserDTO;
import com.example.challenge.Services.DTOs.UserDTO;

import java.util.ArrayList;

public class UserMapper {

    public FollowerCountDTO userToFollowerCount(User user) {
        FollowerCountDTO followerCountDTO = new FollowerCountDTO();
        followerCountDTO.setId(user.getId());
        followerCountDTO.setName(user.getName());
        followerCountDTO.setCount(user.getFollowers().size());
        return followerCountDTO;
    }

    public GetUserDTO userToGetUser(User user) {
        GetUserDTO getUserDTO = new GetUserDTO();
        getUserDTO.setId(user.getId());
        getUserDTO.setName(user.getName());
        getUserDTO.setFollowed( new ArrayList<>());
        getUserDTO.setFollowers(new ArrayList<>());
        for (User u : user.getFollowed()) {
            UserDTO us = new UserDTO(u.getId(), u.getName());
            getUserDTO.getFollowed().add(us);
        }
        for (User u : user.getFollowers()) {
            UserDTO us = new UserDTO(u.getId(), u.getName());
            getUserDTO.getFollowers().add(us);

        }
        getUserDTO.setPosts(user.getPosts());
        return getUserDTO;
    }

    public FollowersDTO userToFollowers(User user){
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setFollowers(new ArrayList<>());
        followersDTO.setUserName(user.getName());
        followersDTO.setId(user.getId());
        for(User u : user.getFollowers()){
            followersDTO.getFollowers().add(new UserDTO(u.getId(), u.getName()));
        }
        return followersDTO;
    }

    public FollowersDTO userToFollowed(User user){
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setFollowers(new ArrayList<>());
        followersDTO.setUserName(user.getName());
        followersDTO.setId(user.getId());
        for(User u : user.getFollowed()){
            followersDTO.getFollowers().add(new UserDTO(u.getId(), u.getName()));
        }
        return followersDTO;
    }
}
