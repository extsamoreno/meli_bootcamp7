package com.spring.desafioSpring.Services;

import com.spring.desafioSpring.DTOs.CountUserFollowersDTO;
import com.spring.desafioSpring.DTOs.FollowedUserDTO;
import com.spring.desafioSpring.DTOs.FollowersUserDTO;
import com.spring.desafioSpring.DTOs.UserDTO;
import com.spring.desafioSpring.Exceptions.FollowYourselfException;
import com.spring.desafioSpring.Exceptions.PropertyNotFoundException;
import com.spring.desafioSpring.Exceptions.UserNotFoundException;

public interface IUserService {
    void follow(int userId, int userIdToFollow) throws UserNotFoundException, FollowYourselfException;
    void unfollow(int userId, int userIdToUnollow) throws UserNotFoundException;
    CountUserFollowersDTO countFollowers(int userId) throws UserNotFoundException;
    FollowersUserDTO followersByUser(int userId, String order) throws UserNotFoundException, PropertyNotFoundException;
    FollowedUserDTO followedByUser(int userId, String order) throws UserNotFoundException, PropertyNotFoundException;
    UserDTO getUserById(int userId) throws UserNotFoundException;

}
