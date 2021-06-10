package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.CantAutofollowException;
import com.example.demo.exceptions.CantUnfollowException;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.exceptions.UserDontFoundException;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    void addUsers();
    void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserDontFoundException, CantAutofollowException;
    void unfollow(int userId, int userIdToFollow) throws UserDontFoundException, CantUnfollowException;
    UserFollowersCountDTO getFollowersCount(int userId) throws UserDontFoundException;
    UserFollowerListDTO getFollowersList(int userId, String order) throws UserDontFoundException;
    UserFollowedListDTO getFollowedList(int userId, String order) throws UserDontFoundException;

}
