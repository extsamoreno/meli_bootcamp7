package com.example.socialmeli.service;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    //Add one User
    @Override
    public ResponseStatus userAdd(UserDTO user) {
        return iUserRepository.userAdd(user);
    }
    //Add a List of Users
    @Override
    public ResponseStatus userAddList(List<UserDTO> user) {
        return iUserRepository.userAddList(user);
    }

    //Requirement 1
    //Follow user
    @Override
    public boolean userFollow(int userid, int useridFollow) {
        return iUserRepository.userFollow(userid, useridFollow);
    }

    //Requirement 2
    //get count followers of User
    @Override
    public UserFolCouResponseDTO getFollowersCount(int userId) {
        return iUserRepository.getFollowersCount(userId);
    }
    //Requirement 3
    //get list followers of User
    @Override
    public UserFolsLisResponseDTO getFollowersList(int userId) {
        return iUserRepository.getFollowersList(userId);
    }

    //Requirement 4
    //get list of followed User
    @Override
    public UserFolLisResponseDTO getFollowedList(int userId) {
        return iUserRepository.getFollowedList(userId);
    }

    //Requirement 7
    //Unfollow user
    @Override
    public boolean userUnFollow(int userid, int useridFollow) {
        return iUserRepository.userUnFollow(userid, useridFollow);
    }
}
