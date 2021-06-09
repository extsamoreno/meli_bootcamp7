package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.exceptions.UserDoesntExistException;
import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface UserService {
    void addUsers();
    void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserDoesntExistException;
    void unfollow(int userId, int userIdToFollow);
    UserFollowersCountDTO getFollowersCount(int userId) throws UserDoesntExistException;
    UserFollowerListDTO getFollowersList(int userId, String order) throws UserDoesntExistException;
    UserFollowedListDTO getFollowedList(int userId, String order) throws UserDoesntExistException;
    //NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO) throws ParseException;
    //FollowedPostListResponseDTO getFollowedPostList(int userId, String order);

}
