package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.UserAlreadyFollowedException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.exceptions.UserSameIdException;
import com.socialmeli.socialmeli.services.dtos.UserDTO;
import java.util.Optional;

public interface UserService {
    public void followUser(int userId , int userIdToFollow) throws UserNotFoundException, UserSameIdException, UserAlreadyFollowedException;
    public void unFollowUser(int userId , int userIdToUnFollow) throws UserNotFoundException;
    public UserDTO getUserFollowersCount(int userId) throws UserNotFoundException;
    public UserDTO getUserFollowers(int userId, Optional<String> order) throws UserNotFoundException;
    public UserDTO getUserFollowed(int userId,Optional<String> order) throws UserNotFoundException;
}
