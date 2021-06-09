package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.CountFollowersDTO;
import com.bootcamp.desafio1.dto.FollowedListDTO;
import com.bootcamp.desafio1.dto.FollowersListDTO;
import com.bootcamp.desafio1.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;

public interface IUserService {

    void createFollow(int userId, int userIdToFollow) throws UserNotFoundException;

    void createUnFollow(int userId, int userIdToUnfollow) throws UserNotFoundException;

    CountFollowersDTO countFollowers(int id) throws UserNotFoundException;

    FollowersListDTO listFollowers(int id, String order) throws UserNotFoundException;

    FollowedListDTO listFollowed(int id, String order) throws UserNotFoundException;



}
