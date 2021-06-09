package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.response.CountFollowersDTO;
import com.bootcamp.desafio1.dto.response.FollowedListDTO;
import com.bootcamp.desafio1.dto.response.FollowersListDTO;
import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.UserNotFoundException;

public interface IUserService {

    void createFollow(int userId, int userIdToFollow) throws UserNotFoundException;

    void createUnFollow(int userId, int userIdToUnfollow) throws UserNotFoundException;

    CountFollowersDTO countFollowers(int id) throws UserNotFoundException;

    FollowersListDTO listFollowers(int id, String order) throws UserNotFoundException;

    FollowedListDTO listFollowed(int id, String order) throws UserNotFoundException;

    void addPostId(int userId, int postId) throws UserNotFoundException, PostAlreadyExistsException;



}
