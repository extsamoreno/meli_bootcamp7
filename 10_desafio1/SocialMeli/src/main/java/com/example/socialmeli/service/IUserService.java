package com.example.socialmeli.service;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.exceptions.UserFollowthisUserException;
import com.example.socialmeli.exceptions.UserIdNotFountException;

import java.util.List;

public interface IUserService {
    //Add user in list memory
    UserDTO userAdd(UserDTO user);

    //get user in list memory by userId
    UserDTO getUserById(int userId);

    //Add list user in list memory
    List<UserDTO> userAddList(List<UserDTO> user);

    //User follow to user
    boolean userFollow(int userid, int useridFollow) throws UserFollowthisUserException;

    //Get follower count to user
    UserFolCouResponseDTO getFollowersCount(int userId) throws UserIdNotFountException;

    //Get follower list to user
    UserFolsLisResponseDTO getFollowersList(int userId, String order) throws UserIdNotFountException;

    //Get followed list to user
    UserFolLisResponseDTO getFollowedList(int userId, String order) throws UserIdNotFountException;

    //User unfollow to user
    boolean userUnFollow(int userid, int useridFollow) throws UserFollowthisUserException;
}
