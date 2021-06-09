package com.example.demo.repositories;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.exceptions.UserDoesntExistException;
import com.example.demo.model.Category;
import com.example.demo.model.User;

import java.text.ParseException;

public interface UserRepository {

    void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserDoesntExistException;
    void unfollow(int userId, int userIdToUnfollow);
    UserFollowersCountDTO getFollowersCount(int userId) throws UserDoesntExistException;
    UserFollowerListDTO getFollowersList(int userId,String order) throws UserDoesntExistException;
    UserFollowedListDTO getFollowedList(int userId,String order) throws UserDoesntExistException;
    User findUserById(int userId);
    NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO,Category category) throws ParseException;
    FollowedPostListResponseDTO getFollowedPostList(int userId, String order);
}
