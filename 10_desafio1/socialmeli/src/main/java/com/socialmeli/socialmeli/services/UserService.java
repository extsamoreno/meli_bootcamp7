package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.services.dtos.UserDTO;

public interface UserService {
    public void followUser(int userId , int userIdToFollow) throws UserNotFoundException;
    public UserDTO getUserFollowersCount(int userId) throws UserNotFoundException;
}
