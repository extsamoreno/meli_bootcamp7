package com.meli.desafio.repository;

import com.meli.desafio.exceptions.UserNotFoundException;
import com.meli.desafio.models.User;
import com.meli.desafio.models.dto.UserDTO;

import java.util.List;

public interface IUserRepository {
    User getById(Integer userId) throws UserNotFoundException;

    User getByName(String userName) throws UserNotFoundException;

    List<UserDTO> getFollowersTo(User user);
}
