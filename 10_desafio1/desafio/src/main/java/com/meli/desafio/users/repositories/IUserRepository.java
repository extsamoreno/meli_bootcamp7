package com.meli.desafio.users.repositories;

import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.UserDTO;

import java.util.List;

public interface IUserRepository {
    User getById(Integer userId) throws UserNotFoundException;

    User getByName(String userName) throws UserNotFoundException;

    List<Integer> getFollowersTo(User user);

    boolean userExist(Integer userId);

    void removeFollow(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException;
}
