package com.example.demo.repositories;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.*;
import com.example.demo.model.Category;
import com.example.demo.model.User;

import java.text.ParseException;

public interface UserRepository {

    void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserDontFoundException, CantAutofollowException;
    void unfollow(int userId, int userIdToUnfollow) throws UserDontFoundException, CantUnfollowException;
    UserFollowersCountDTO getFollowersCount(int userId) throws UserDontFoundException;
    UserFollowerListDTO getFollowersList(int userId,String order) throws UserDontFoundException;
    UserFollowedListDTO getFollowedList(int userId,String order) throws UserDontFoundException;
    User findUserById(int userId);
    NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO,Category category) throws ParseException, UserDontFoundException, InvalidDateFormatException;
    FollowedPostListResponseDTO getFollowedPostList(int userId, String order) throws InvalidDateFormatException;
    NewPostWithPromResponseDTO newPostWithProm(NewPostWithPromRequestDTO newPostWithPromRequestDTO,Category category) throws ParseException, UserDontFoundException, InvalidDateFormatException;
    PostWithPromCountDTO getProductsWithPromCount(int userId);
    PostWithPromListResponseDTO getPostWithPromList(int userId) throws InvalidDateFormatException;
}
