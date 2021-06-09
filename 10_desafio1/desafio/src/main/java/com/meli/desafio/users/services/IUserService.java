package com.meli.desafio.users.services;

import com.meli.desafio.users.exceptions.UserAlredyFollowedException;
import com.meli.desafio.users.exceptions.UserFollowYourselfException;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.users.models.dto.ResponseUserListFollowed;
import com.meli.desafio.users.models.dto.ResponseUserListFollowers;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void addNewFollow(Integer userId, Integer userIdToFollow) throws UserNotFoundException, UserFollowYourselfException, UserAlredyFollowedException;

    ResponseUserCountFollowers showCountFollowers(Integer userId) throws UserNotFoundException;

    ResponseUserListFollowers showAllFollowers(Integer userId, String order) throws UserNotFoundException;

    ResponseUserListFollowed showAllFollowed(Integer userId, String order) throws UserNotFoundException;

    boolean userExist(Integer userId);

    User getById(Integer userId) throws UserNotFoundException;

    void removeFollow(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException;
}
