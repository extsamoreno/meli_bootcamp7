package com.meli.desafio.users.services;

import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.users.models.dto.ResponseUserListFollowers;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void addNewFollow(Integer userId, Integer userIdToFollow) throws UserNotFoundException;

    ResponseUserCountFollowers showCountFollowers(Optional<Integer> userId, Optional<String> userName) throws UserNotFoundException;

    ResponseUserListFollowers showAllFollowers(Integer userId, String order) throws UserNotFoundException;

    User showAllFollowed(Integer userId, String order) throws UserNotFoundException;

    boolean userExist(Integer userId);

    User getById(Integer userId) throws UserNotFoundException;

    void removeFollow(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException;
}
