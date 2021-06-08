package com.meli.desafio.services;

import com.meli.desafio.exceptions.UserNotFoundException;
import com.meli.desafio.models.User;
import com.meli.desafio.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.models.dto.ResponseUserListFollowers;

import java.util.Optional;

public interface IUserService {
    void addNewFollow(Integer userId, Integer userIdToFollow) throws UserNotFoundException;

    ResponseUserCountFollowers showCountFollowers(Optional<Integer> userId, Optional<String> userName) throws UserNotFoundException;

    ResponseUserListFollowers showAllFollowers(Integer userId) throws UserNotFoundException;

    User showAllFollowed(Integer userId) throws UserNotFoundException;
}
