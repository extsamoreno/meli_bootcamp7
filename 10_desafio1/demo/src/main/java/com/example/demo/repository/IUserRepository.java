package com.example.demo.repository;

import com.example.demo.DTO.FollowersListDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exception.FollowersNotFoundException;
import com.example.demo.exception.UserNotFoundException;

import java.util.List;

public interface IUserRepository {

    public UserDTO findById(Integer userId) throws UserNotFoundException;

    public void follow(UserDTO userId, UserDTO userIdToFollow);

    Integer countFollowers(UserDTO user) ;

    List<UserDTO> followersList(Integer userId);
}
