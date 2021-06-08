package com.spring.desafioSpring.Services;

import com.spring.desafioSpring.DTOs.CountUserFollowersDTO;
import com.spring.desafioSpring.DTOs.FollowedUserDTO;
import com.spring.desafioSpring.DTOs.FollowersUserDTO;
import com.spring.desafioSpring.Exceptions.FollowYourselfException;
import com.spring.desafioSpring.Exceptions.UserNotFoundException;

public interface IUserService {
    void follow(int userId, int userIdToFollow) throws UserNotFoundException, FollowYourselfException;
    CountUserFollowersDTO countFollowers(int userId) throws UserNotFoundException;
    FollowersUserDTO followersByUser(int userId) throws UserNotFoundException;
    FollowedUserDTO followedByUser(int userId) throws UserNotFoundException;

}
